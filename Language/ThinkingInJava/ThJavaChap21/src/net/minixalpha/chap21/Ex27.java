package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Meal4 {
	private final int orderNum;

	public Meal4(int orderNum) {
		this.orderNum = orderNum;
	}

	public String toString() {
		return "Meal " + orderNum;
	}
}

class WaitPerson4 implements Runnable {
	private Restaurant4 restaurant;
	public Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public WaitPerson4(Restaurant4 r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				lock.lock();
				while (restaurant.meal == null) {
					System.out.println("waitperson0");
					condition.await();
					System.out.println("waitperson1");

				}

				System.out.println("Waitperson got " + restaurant.meal);

				restaurant.chef.lock.lock();
				restaurant.meal = null;
				restaurant.chef.condition.signalAll();
				restaurant.chef.lock.unlock();

			}
		} catch (InterruptedException e) {
			System.out.println("WaitPerson interrupted");
		} finally {
			lock.unlock();
		}
	}
}

class Chef4 implements Runnable {
	private Restaurant4 restaurant;
	private int count = 0;
	public Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	public Chef4(Restaurant4 r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				while (restaurant.meal != null) {
					System.out.println("chef0");
					condition.await(); // ... for the meal to be taken
					System.out.println("chef1");
				}

				if (++count == 10) {
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.println("Order up! ");

				restaurant.waitPerson.lock.lock();
				restaurant.meal = new Meal4(count);
				restaurant.waitPerson.condition.signalAll();
				restaurant.waitPerson.lock.unlock();

				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}
}

class Restaurant4 {
	Meal4 meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson4 waitPerson = new WaitPerson4(this);
	Chef4 chef = new Chef4(this);

	public Restaurant4() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant4();
	}
}

public class Ex27 {
	public static void main(String[] args) {
		Restaurant4.main(args);
	}
}
