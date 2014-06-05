package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RadiationCounter {
	private volatile int counter;

	public synchronized void increment() {
		counter += 1;
	}

	public synchronized int get() {
		return counter;
	}
}

class RemoteSensor implements Runnable {
	private int id;
	private static RadiationCounter counter = new RadiationCounter();
	private static boolean cancel = false;
	private int localCounter = 0;

	public RemoteSensor(int id) {
		this.id = id;
	}

	public static RadiationCounter getCounter() {
		return counter;
	}

	public void increment() {
		localCounter++;
		counter.increment();
	}

	public String toString() {
		return id + " " + localCounter + " total:" + counter.get();
	}

	public static void cancel() {
		cancel = true;
	}

	@Override
	public void run() {
		while (cancel == false) {
			increment();
		}
		System.out.println(this);
	}
}

public class Ex17 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(new RemoteSensor(i));
		}
		RemoteSensor.cancel();
		TimeUnit.SECONDS.sleep(3);
		service.shutdown();
		if (!service.awaitTermination(350, TimeUnit.MICROSECONDS)) {
			System.err.println("Task remaining");
		}
		System.out.println(RemoteSensor.getCounter().get());
	}
}
