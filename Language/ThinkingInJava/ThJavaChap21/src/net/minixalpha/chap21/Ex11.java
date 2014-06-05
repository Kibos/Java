package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface Ex11Demo {
	void set();

	boolean check();

	int getA();

	int getB();
}

class Ex11Demo1 implements Ex11Demo {
	private int a = 0;
	private int b = 0;

	public void set() {
		a++;
		b++;
	}

	@Override
	public boolean check() {
		return a == b;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}
}

class Ex11Demo2 implements Ex11Demo {
	private int a = 0;
	private int b = 0;

	public synchronized void set() {
		a++;
		b++;
	}

	@Override
	public synchronized boolean check() {
		return a == b;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

}

class Ex11DemoHelper implements Runnable {
	private Ex11Demo demo;

	public Ex11DemoHelper(Ex11Demo demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		while (demo.check()) {
			demo.set();
		}
		System.out.println(demo.getA() + " " + demo.getB());
		System.out.println("Failure");
	}
}

// Note: both read and set methods should be synchronized
public class Ex11 {
	static void testTemplate(Ex11Demo demo) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(new Ex11DemoHelper(demo));
		}
		service.shutdown();
	}

	static void testCase1() {
		testTemplate(new Ex11Demo1());
	}

	static void testCase2() {
		testTemplate(new Ex11Demo2());
	}

	public static void main(String[] args) {
		testCase1();
		// testCase2();
	}
}
