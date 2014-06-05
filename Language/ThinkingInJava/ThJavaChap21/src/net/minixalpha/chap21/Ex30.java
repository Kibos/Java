package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.io.*;
import java.util.*;

class Sender implements Runnable {
	private Random rand = new Random(47);
	private LinkedBlockingDeque<Character> bufferQ;

	public Sender(LinkedBlockingDeque<Character> bufferQ) {
		this.bufferQ = bufferQ;
	}

	public LinkedBlockingDeque<Character> getBlockingDeque() {
		return bufferQ;
	}

	public void run() {
		try {
			while (true)
				for (char c = 'A'; c <= 'z'; c++) {
					bufferQ.put(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
		} catch (InterruptedException e) {
			System.out.println(e + " Sender sleep interrupted");
		}
	}
}

class Receiver implements Runnable {
	private LinkedBlockingDeque<Character> bufferQ;

	public Receiver(Sender sender) throws IOException {
		bufferQ = sender.getBlockingDeque();
	}

	public void run() {
		while (true) {
			// Blocks until characters are there:
			try {
				System.out.println("Read: " + bufferQ.take() + ", ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PipedIO {
	public static void main(String[] args) throws Exception {
		LinkedBlockingDeque<Character> bufferQ = new LinkedBlockingDeque<Character>();
		Sender sender = new Sender(bufferQ);
		Receiver receiver = new Receiver(sender);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(4);
		exec.shutdownNow();
	}
}

public class Ex30 {
	public static void main(String[] args) throws Exception {
		PipedIO.main(args);
	}
}
