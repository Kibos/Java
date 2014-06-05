package net.minixalpha.chap21;

import java.util.concurrent.*;

class SimplePrioritiesFactory implements ThreadFactory {
	int newPriority;

	public SimplePrioritiesFactory(int newPriority) {
		this.newPriority = newPriority;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(newPriority);
		return t;
	}

}

class SimplePriorities implements Runnable {
	private int countDown = 5;
	private volatile double d; // No optimization
	private int priority;

	public SimplePriorities(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	public void run() {
//		Thread.currentThread().setPriority(priority);
		while (true) {
			// An expensive, interruptable operation:
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

}

public class Ex9 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new SimplePrioritiesFactory(Thread.MIN_PRIORITY));
		for (int i = 0; i < 5; i++)
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
