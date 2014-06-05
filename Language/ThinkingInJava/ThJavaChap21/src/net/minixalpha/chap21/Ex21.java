package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Ex21Demo1 implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("demo1 run");
		}

	}

}

class Ex21Demo2 implements Runnable {

	private Ex21Demo1 demo1;

	public Ex21Demo2(Ex21Demo1 demo1) {
		this.demo1 = demo1;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);
			synchronized (demo1) { // Get demo1's monitor
				demo1.notifyAll();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class Ex21 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Ex21Demo1 demo1 = new Ex21Demo1();
		service.execute(demo1);
		service.execute(new Ex21Demo2(demo1));
		service.shutdown();
	}
}
