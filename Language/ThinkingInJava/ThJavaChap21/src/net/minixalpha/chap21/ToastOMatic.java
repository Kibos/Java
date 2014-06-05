//: concurrency/Toast0OMatic.java
// A toaster that uses queues.

package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;

class Toast0 {
	public enum Status {
		DRY, BUTTERED, JAMMED
	}

	private Status status = Status.DRY;
	private final int id;

	public Toast0(int idn) {
		id = idn;
	}

	public void butter() {
		status = Status.BUTTERED;
	}

	public void jam() {
		status = Status.JAMMED;
	}

	public Status getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Toast0 " + id + ": " + status;
	}
}

class Toast0Queue extends LinkedBlockingQueue<Toast0> {
}

class Toast0er implements Runnable {
	private Toast0Queue toastQueue;
	private int count = 0;
	private Random rand = new Random(47);

	public Toast0er(Toast0Queue tq) {
		toastQueue = tq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				// Make toast
				Toast0 t = new Toast0(count++);
				System.out.println(t);
				// Insert into queue
				toastQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Toast0er interrupted");
		}
		System.out.println("Toast0er off");
	}
}

// Apply butter to toast:
class Butterer0 implements Runnable {
	private Toast0Queue dryQueue, butteredQueue;

	public Butterer0(Toast0Queue dry, Toast0Queue buttered) {
		dryQueue = dry;
		butteredQueue = buttered;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast0 t = dryQueue.take();
				t.butter();
				System.out.println(t);
				butteredQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Butterer0 interrupted");
		}
		System.out.println("Butterer0 off");
	}
}

// Apply jam to buttered toast:
class Jammer0 implements Runnable {
	private Toast0Queue butteredQueue, finishedQueue;

	public Jammer0(Toast0Queue buttered, Toast0Queue finished) {
		butteredQueue = buttered;
		finishedQueue = finished;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast0 t = butteredQueue.take();
				t.jam();
				System.out.println(t);
				finishedQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Jammer0 interrupted");
		}
		System.out.println("Jammer0 off");
	}
}

// Consume the toast:
class Eater0 implements Runnable {
	private Toast0Queue finishedQueue;
	private int counter = 0;

	public Eater0(Toast0Queue finished) {
		finishedQueue = finished;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast0 t = finishedQueue.take();
				// Verify that the toast is coming in order,
				// and that all pieces are getting jammed:
				if (t.getId() != counter++
						|| t.getStatus() != Toast0.Status.JAMMED) {
					System.out.println(">>>> Error: " + t);
					System.exit(1);
				} else
					System.out.println("Chomp! " + t);
			}
		} catch (InterruptedException e) {
			System.out.println("Eater0 interrupted");
		}
		System.out.println("Eater0 off");
	}
}

public class ToastOMatic {
	public static void main(String[] args) throws Exception {
		Toast0Queue dryQueue = new Toast0Queue(), butteredQueue = new Toast0Queue(), finishedQueue = new Toast0Queue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toast0er(dryQueue));
		exec.execute(new Butterer0(dryQueue, butteredQueue));
		exec.execute(new Jammer0(butteredQueue, finishedQueue));
		exec.execute(new Eater0(finishedQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
} /* (Execute to see output) */// :~
