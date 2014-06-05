package net.minixalpha.chap21;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class Chopstick {
}

class Philosopher implements Runnable {
	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;
	private BlockingDeque<Chopstick> stickContainer;
	private Random rand = new Random(47);

	private void pause() throws InterruptedException {
		if (ponderFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
	}

	public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
		this.left = left;
		this.right = right;
		id = ident;
		ponderFactor = ponder;
	}

	public Philosopher(BlockingDeque<Chopstick> stickContainer, int ident,
			int ponder) {
		this.stickContainer = stickContainer;
		this.ponderFactor = ponder;
		this.id = ident;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println(this + " " + "thinking");
				pause();
				synchronized (stickContainer) {
					left = stickContainer.take();
					right = stickContainer.take();
				}
				System.out.println(this + " grabbing sticks");
				System.out.println(this + " " + "eating");
				pause();
				synchronized (stickContainer) {
					stickContainer.put(left);
					stickContainer.put(right);
				}
			}
		} catch (InterruptedException e) {
			System.out.println(this + " " + "exiting via interrupt");
		}
	}

	public String toString() {
		return "Philosopher " + id;
	}
}

public class Ex31 {
	static void initSticks(BlockingDeque<Chopstick> sticksContainer, int size) {
		for (int i = 0; i < size; i++) {
			sticksContainer.push(new Chopstick());
		}

	}

	public static void main(String[] args) throws Exception {
		int ponder = 0;
		if (args.length > 0)
			ponder = Integer.parseInt(args[0]);
		int size = 5;
		if (args.length > 1)
			size = Integer.parseInt(args[1]);
		ExecutorService exec = Executors.newCachedThreadPool();

		BlockingDeque<Chopstick> sticksContainer = new LinkedBlockingDeque<Chopstick>();
		initSticks(sticksContainer, size);

		for (int i = 0; i < size; i++) {
			exec.execute(new Philosopher(sticksContainer, i, ponder));
		}
		if (args.length == 3 && args[2].equals("timeout"))
			TimeUnit.SECONDS.sleep(5);
		else {
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}
}
