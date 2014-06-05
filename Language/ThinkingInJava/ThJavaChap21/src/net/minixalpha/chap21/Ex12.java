package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Atomicity {
	private static int i;

	synchronized static int f1() {
		i++;
		return i;
	}

	synchronized static int f2() {
		i += 3;
		return i;
	}

}

class CircularSet2 {
	private int[] array;
	private int len;
	private int index = 0;

	public CircularSet2(int size) {
		array = new int[size];
		len = size;
		// Initialize to a value not produced
		// by the SerialNumberGenerator:
		for (int i = 0; i < size; i++)
			array[i] = -1;
	}

	public synchronized void add(int i) {
		array[index] = i;
		// Wrap index and write over old elements:
		index = ++index % len;
	}

	public synchronized boolean contains(int val) {
		for (int i = 0; i < len; i++)
			if (array[i] == val)
				return true;
		return false;
	}
}

class SerialNumberChecker2 {
	private static final int SIZE = 10;
	private static CircularSet2 serials = new CircularSet2(1000);
	private static ExecutorService exec = Executors.newCachedThreadPool();

	static class SerialChecker implements Runnable {
		public void run() {
			while (true) {
				// Atomicity.f1();
				int serial = Atomicity.f1();
				if (serials.contains(serial)) {
					System.out.println("Duplicate: " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}

	static class SerialChecker2 implements Runnable {
		public void run() {
			while (true) {
				int serial = Atomicity.f2();
				if (serials.contains(serial)) {
					System.out.println("Duplicate: " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}

	public static void testCase1(String[] args) throws NumberFormatException,
			InterruptedException {
		for (int i = 0; i < SIZE; i++)
			exec.execute(new SerialChecker());
		// Stop after n seconds if there's an argument:
		if (args.length > 0) {
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
			System.out.println("No duplicates detected");
			System.exit(0);
		}
	}

	public static void testCase2(String[] args) throws NumberFormatException,
			InterruptedException {
		for (int i = 0; i < SIZE; i++)
			exec.execute(new SerialChecker2());
		// Stop after n seconds if there's an argument:
		if (args.length > 0) {
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
			System.out.println("No duplicates detected");
			System.exit(0);
		}
	}

	public static void main(String[] args) throws Exception {
		// testCase1(args);
		testCase2(args);
	}
}

public class Ex12 {
	public static void main(String[] args) throws Exception {
		SerialNumberChecker2.main(args);
	}
}
