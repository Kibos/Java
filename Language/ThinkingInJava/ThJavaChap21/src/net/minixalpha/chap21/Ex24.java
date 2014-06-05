package net.minixalpha.chap21;

import java.util.*;
import java.util.concurrent.*;

class Meal {
	private volatile int count;
	private final int capacity = 10;

	public String toString() {
		return "Meal " + count;
	}

	public synchronized int produce() {
		while (count > capacity) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		notifyAll();
		return count;
	}

	public synchronized int consume() throws InterruptedException {
		while (count <= 0) {
			wait();
		}

		int oldCount = count;
		count--;
		notifyAll();
		return oldCount;
	}
}

class WaitPerson implements Runnable {
	private Restaurant restaurant;

	public WaitPerson(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		while (!Thread.interrupted()) {
			synchronized (restaurant.meal) {
				try {
					System.out.println("Waitperson got "
							+ restaurant.meal.consume());
				} catch (InterruptedException e) {
					System.out.println("WaitPerson interrupted");
				}
			}
		}
	}
}

class Chef implements Runnable {
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant r) {
		restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (restaurant.meal) {
					System.out.println("Chef produce "
							+ restaurant.meal.produce());
				}

				if (++count == 10) {
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}
}

class Restaurant {
	Meal meal = new Meal();
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
}

public class Ex24 {
	public static void main(String[] args) {
		Restaurant.main(args);
	}
}
