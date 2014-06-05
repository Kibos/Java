package net.minixalpha.chap21;

import java.util.concurrent.*;

class Car42 {
}

class WaxOn42 implements Runnable {
	private Car42 car;

	public WaxOn42(Car42 c) {
		car = c;
	}

	public void run() {
		try {
			if (!Thread.interrupted()) {
				System.out.println("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
	}
}

class WaxOff42 implements Runnable {
	private Car42 car;

	public WaxOff42(Car42 c) {
		car = c;
	}

	public void run() {
		try {
			if (!Thread.interrupted()) {
				System.out.println("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
	}
}

class CarActiveObject implements Runnable {
	private ExecutorService exec = Executors.newSingleThreadExecutor();
	private Car42 car;

	public CarActiveObject(Car42 car) {
		this.car = car;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			exec.submit(new WaxOn42(car));
			exec.submit(new WaxOff42(car));
		}
		exec.shutdown();
	}

}

class WaxOMatic42 {
	public static void main(String[] args) throws Exception {
		Car42 car = new Car42();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new CarActiveObject(car));
		TimeUnit.SECONDS.sleep(5); // Run for a while...
		exec.shutdownNow(); // Interrupt all tasks
	}
}

public class Ex42 {
	public static void main(String[] args) throws Exception {
		WaxOMatic42.main(args);
	}
}
