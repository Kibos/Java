package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;

class Count2 {
	private int count = 0;
	private Random rand = new Random(47);

	// Remove the synchronized keyword to see counting fail:
	public synchronized int increment() {
		int temp = count;
		if (rand.nextBoolean()) // Yield half the time
			Thread.yield();
		return (count = ++temp);
	}

	public synchronized int value() {
		return count;
	}
}

class Entrance2 implements Runnable {
	private static Count2 count = new Count2();
	private static List<Entrance2> entrances = new ArrayList<Entrance2>();
	private int number = 0;
	// Doesn't need synchronization to read:
	private final int id;
	private static volatile boolean canceled = false;
	private final CountDownLatch latch;

	// Atomic operation on a volatile field:
	public static void cancel() {
		canceled = true;
	}

	public Entrance2(int id, CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
		// Keep this task in a list. Also prevents
		// garbage collection of dead tasks:
		entrances.add(this);
	}

	public void run() {
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
			}

			latch.countDown();
		}
		System.out.println("Stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}

	public static int getTotalCount() {
		return count.value();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance2 entrance : entrances)
			sum += entrance.getValue();
		return sum;
	}
}

class OrnamentalGarden2 {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(200);
		for (int i = 0; i < 5; i++)
			exec.execute(new Entrance2(i, latch));
		// Run for a while, then stop and collect the data:
		latch.await();
		Entrance2.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			System.out.println("Some tasks were not terminated!");
		System.out.println("Total: " + Entrance2.getTotalCount());
		System.out.println("Sum of Entrances: " + Entrance2.sumEntrances());
	}
}

public class Ex32 {
	public static void main(String[] args) throws Exception {
		OrnamentalGarden2.main(args);
	}
}
