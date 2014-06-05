package net.minixalpha.chap21;

import java.util.concurrent.*;

class Meal3 {
	private final int orderNum;

	public Meal3(int orderNum) {
		this.orderNum = orderNum;
	}

	public String toString() {
		return "Meal " + orderNum;
	}
}

class BusBoy implements Runnable {

	private Restaurant3 restaurant;

	public BusBoy(Restaurant3 r) {
		restaurant = r;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				synchronized (this) {
					wait();
					System.out.println("clean");
				}

				synchronized (restaurant.chef) {
					restaurant.chef.notifyAll(); // Ready for another
				}

			} catch (InterruptedException e) {
				System.out.println("BusyBoy interrupted");
			}
		}
	}

}

class WaitPerson3 implements Runnable {
	private Restaurant3 restaurant;

	public WaitPerson3(Restaurant3 r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal == null)
						wait(); // ... for the chef to produce a meal
				}
				System.out.println("Waitperson got " + restaurant.meal);

				synchronized (restaurant.chef) {
					restaurant.meal = null;
				}

				synchronized (restaurant.boy) {
					restaurant.boy.notifyAll();
				}

			}
		} catch (InterruptedException e) {
			System.out.println("WaitPerson interrupted");
		}
	}
}

class Chef3 implements Runnable {
	private Restaurant3 restaurant;
	private int count = 0;

	public Chef3(Restaurant3 r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal != null)
						wait(); // ... for the meal to be taken
				}
				if (++count == 10) {
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.println("Order up! ");
				synchronized (restaurant.waitPerson) {
					restaurant.meal = new Meal3(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}
}

class Restaurant3 {
	Meal3 meal;

	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson3 waitPerson = new WaitPerson3(this);
	Chef3 chef = new Chef3(this);
	BusBoy boy = new BusBoy(this);

	public Restaurant3() {
		exec.execute(chef);
		exec.execute(waitPerson);
		exec.execute(boy);
	}

	public static void main(String[] args) {
		new Restaurant3();
	}
}

public class Ex26 {
	public static void main(String[] args) {
		Restaurant3.main(args);
	}
}
