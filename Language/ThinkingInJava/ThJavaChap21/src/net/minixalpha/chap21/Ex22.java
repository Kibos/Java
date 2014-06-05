package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Ex22Demo1 implements Runnable {
	private volatile boolean flag = false; // should set to volatile
	private Ex22Demo3 demo3 = null;

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;
		if (demo3 != null) {
			synchronized (demo3) {
				demo3.notifyAll();
			}
		}
	}

	public void setDemo3(Ex22Demo3 demo3) {
		this.demo3 = demo3;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

class Ex22Demo2 implements Runnable {

	private Ex22Demo1 demo1;

	public Ex22Demo2(Ex22Demo1 demo1) {
		this.demo1 = demo1;
	}

	@Override
	public void run() {
		long startTime = System.nanoTime();
		while (demo1.getFlag() == false) {
		}
		demo1.setFlag(false);
		long duration = System.nanoTime() - startTime;
		System.out.println("wait end: " + duration);
	}

}

class Ex22Demo3 implements Runnable {

	private Ex22Demo1 demo1;

	public Ex22Demo3(Ex22Demo1 demo1) {
		this.demo1 = demo1;
		demo1.setDemo3(this);
	}

	@Override
	public void run() {
		long startTime = System.nanoTime();
		while (demo1.getFlag() == false) {
			try {
				synchronized (this) {
					wait();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		demo1.setFlag(false);
		long duration = System.nanoTime() - startTime;
		System.out.println("wait end: " + duration);
	}

}

public class Ex22 {
	static void testCase1() {
		ExecutorService service = Executors.newCachedThreadPool();
		Ex22Demo1 demo1 = new Ex22Demo1();
		service.execute(demo1);
		service.execute(new Ex22Demo2(demo1));
		service.shutdown();
	}

	static void testCase2() {
		ExecutorService service = Executors.newCachedThreadPool();
		Ex22Demo1 demo1 = new Ex22Demo1();
		Ex22Demo3 demo3 = new Ex22Demo3(demo1);
		service.execute(demo1);
		service.execute(demo3);
		service.shutdown();
	}

	public static void main(String[] args) {
//		testCase1(); //999687044
		testCase2(); //999999229
	}
}
