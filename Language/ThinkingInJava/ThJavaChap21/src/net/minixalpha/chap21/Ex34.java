package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;

class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;

	public BasicGenerator(Class<T> type) {
		this.type = type;
	}

	public T next() {
		try {
			// Assumes type is a public class:
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Produce a Default generator given a type token:
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}
}

class ExchangerProducer<T> implements Runnable {
	private Generator<T> generator;
	private Exchanger<List<T>> exchanger;
	private List<T> holder;

	ExchangerProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
		exchanger = exchg;
		generator = gen;
		this.holder = holder;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				for (int i = 0; i < ExchangerDemo.size; i++)
					holder.add(generator.next());
				// Exchange full for empty:
				holder = exchanger.exchange(holder);
			}
		} catch (InterruptedException e) {
			// OK to terminate this way.
		}
	}
}

class ExchangerConsumer<T> implements Runnable {
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;

	ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
		exchanger = ex;
		this.holder = holder;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				holder = exchanger.exchange(holder);
				for (T x : holder) {
					value = x; // Fetch out value
					holder.remove(x); // OK for CopyOnWriteArrayList
				}
			}
		} catch (InterruptedException e) {
			// OK to terminate this way.
		}
		System.out.println("Final value: " + value);
	}
}

class Ex34Demo {
	public String toString() {
		return "demo";
	}
}

class ExchangerDemo {
	static int size = 10;
	static int delay = 5; // Seconds

	public static void main(String[] args) throws Exception {
		if (args.length > 0)
			size = new Integer(args[0]);
		if (args.length > 1)
			delay = new Integer(args[1]);
		ExecutorService exec = Executors.newCachedThreadPool();
		Exchanger<List<Ex34Demo>> xc = new Exchanger<List<Ex34Demo>>();
		List<Ex34Demo> producerList = new CopyOnWriteArrayList<Ex34Demo>(), consumerList = new CopyOnWriteArrayList<Ex34Demo>();
		exec.execute(new ExchangerProducer<Ex34Demo>(xc, BasicGenerator
				.create(Ex34Demo.class), producerList));
		exec.execute(new ExchangerConsumer<Ex34Demo>(xc, consumerList));
		TimeUnit.SECONDS.sleep(delay);
		exec.shutdownNow();
	}
}

public class Ex34 {
	public static void main(String[] args) throws Exception {
		ExchangerDemo.main(args);
	}
}
