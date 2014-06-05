package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;

class Toast {
	public enum Status {
		DRY, BUTTERED, JELLYED, JAMMED,
	}

	private Status status = Status.DRY;
	private final int id;

	public Toast(int idn) {
		id = idn;
	}

	public void butter() {
		status = Status.BUTTERED;
	}

	public void jellyer() {
		status = Status.JELLYED;
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
		return "Toast " + id + ": " + status;
	}
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count = 0;
	private Random rand = new Random(47);

	public Toaster(ToastQueue tq) {
		toastQueue = tq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				// Make toast
				Toast t = new Toast(count++);
				System.out.println(t);
				// Insert into queue
				toastQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toaster off");
	}
}

// Apply butter to toast:
class Butterer implements Runnable {
	private ToastQueue dryQueue, butteredQueue;
	private Object objSync;

	public Butterer(ToastQueue dry, ToastQueue buttered, Object obj) {
		dryQueue = dry;
		butteredQueue = buttered;
		objSync = obj;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t;
				// synchronized (dryQueue) {
				t = dryQueue.take();
				t.butter();
				System.out.println(t);
				butteredQueue.put(t);
				// }

			}
		} catch (InterruptedException e) {
			System.out.println("Butterer interrupted");
		}
		System.out.println("Butterer off");
	}
}

// Apply butter to toast:
class Jellyer implements Runnable {
	private ToastQueue dryQueue, jellyedQueue;
	private Object objSync;

	public Jellyer(ToastQueue dry, ToastQueue jellyed, Object obj) {
		dryQueue = dry;
		jellyedQueue = jellyed;
		objSync = obj;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t;
				// synchronized (dryQueue) {
				t = dryQueue.take();
				t.jellyer();
				System.out.println(t);
				jellyedQueue.put(t);
				// }
			}
		} catch (InterruptedException e) {
			System.out.println("Jellyer interrupted");
		}
		System.out.println("Jellyer off");
	}
}

// Apply jam to buttered toast:
class Jammer implements Runnable {
	private ToastQueue butteredQueue, finishedQueue, jellyedQueue;
	private static Random rand = new Random();
	private Object objSync;

	public Jammer(ToastQueue buttered, ToastQueue jellyed, ToastQueue finished,
			Object obj) {
		butteredQueue = buttered;
		finishedQueue = finished;
		jellyedQueue = jellyed;
		objSync = obj;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t;
				// synchronized (objSync) {
				int choose = rand.nextInt(2);
				if (choose == 0) {
					t = jellyedQueue.take();
				} else {
					t = butteredQueue.take();
				}
				t.jam();
				System.out.println(t);
				finishedQueue.put(t);
				// }

			}
		} catch (InterruptedException e) {
			System.out.println("Jammer interrupted");
		}
		System.out.println("Jammer off");
	}
}

// Consume the toast:
class Eater implements Runnable {
	private ToastQueue finishedQueue;
	private int counter = 0;

	public Eater(ToastQueue finished) {
		finishedQueue = finished;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t = finishedQueue.take();
				// Verify that the toast is coming in order,
				// and that all pieces are getting jammed:
				// if (t.getId() != counter++
				// || t.getStatus() != Toast.Status.JAMMED) {
				if (t.getStatus() != Toast.Status.JAMMED) {
					System.out
							.println(">>>> Error: " + t + " " + (counter - 1));
					System.exit(1);
				} else
					System.out.println("Chomp! " + t);
			}
		} catch (InterruptedException e) {
			System.out.println("Eater interrupted");
		}
		System.out.println("Eater off");
	}
}

class ToastOMatic1 {
	public static void main(String[] args) throws Exception {
		ToastQueue dryQueue = new ToastQueue(), butteredQueue = new ToastQueue(), finishedQueue = new ToastQueue(), jellyedQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		Object objSync = new Object();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue, objSync));
		exec.execute(new Jellyer(dryQueue, jellyedQueue, objSync));
		exec.execute(new Jammer(butteredQueue, jellyedQueue, finishedQueue,
				objSync));
		exec.execute(new Eater(finishedQueue));
		TimeUnit.SECONDS.sleep(10);
		exec.shutdownNow();
	}
}

public class Ex29 {
	public static void main(String[] args) throws Exception {
		ToastOMatic1.main(args);
	}
}
