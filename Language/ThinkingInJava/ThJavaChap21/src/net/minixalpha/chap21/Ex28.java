package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.io.*;

class LiftOffRunner implements Runnable {
	private BlockingQueue<LiftOff> rockets;

	public LiftOffRunner(BlockingQueue<LiftOff> queue) {
		rockets = queue;
	}

	public void add(LiftOff lo) {
		try {
			rockets.put(lo);
		} catch (InterruptedException e) {
			System.out.println("Interrupted during put()");
		}
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				LiftOff rocket = rockets.take();
				rocket.run(); // Use this thread
			}
		} catch (InterruptedException e) {
			System.out.println("Waking from take()");
		}
		System.out.println("Exiting LiftOffRunner");
	}
}

class TestBlockingQueues {
	static void getkey() {
		try {
			// Compensate for Windows/Linux difference in the
			// length of the result produced by the Enter key:
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (java.io.IOException e) {
			throw new RuntimeException(e);
		}
	}

	static void getkey(String message) {
		System.out.println(message);
		getkey();
	}

	static void test(String msg, BlockingQueue<LiftOff> queue) {
		System.out.println(msg);
		LiftOffRunner runner = new LiftOffRunner(queue);
		Thread t = new Thread(runner);
		t.start();
		for (int i = 0; i < 5; i++)
			runner.add(new LiftOff(5));
		getkey("Press 'Enter' (" + msg + ")");
		t.interrupt();
		System.out.println("Finished " + msg + " test");
	}

	private static class AddToQueueTask implements Runnable {

		@Override
		public void run() {
			test("LinkedBlockingQueue", // Unlimited size
					new LinkedBlockingQueue<LiftOff>());
			test("ArrayBlockingQueue", // Fixed size
					new ArrayBlockingQueue<LiftOff>(3));
			test("SynchronousQueue", // Size of 1
					new SynchronousQueue<LiftOff>());
		}

	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new AddToQueueTask());
		service.shutdown();
	}
}

public class Ex28 {
	public static void main(String[] args) {
		TestBlockingQueues.main(args);
	}
}
