package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Ex15Demo {
	public void f() {

		for (int i = 0; i < 5; i++) {
			System.out.println("f()");
			Thread.yield();
		}
	}

	public void g() {
		for (int i = 0; i < 5; i++) {
			System.out.println("g()");
			Thread.yield();
		}
	}

	public void h() {
		for (int i = 0; i < 5; i++) {
			System.out.println("h()");
			Thread.yield();
		}
	}
}

class Ex15Demo1 extends Ex15Demo {
	private Object synObject = new Object();

	public void f() {
		synchronized (synObject) {
			super.f();
		}
	}

	public void g() {
		synchronized (synObject) {
			super.g();
		}
	}

	public void h() {
		synchronized (synObject) {
			super.h();
		}
	}
}

class Ex15Demo2 extends Ex15Demo {
	private Object synObjectF = new Object();
	private Object synObjectG = new Object();
	private Object synObjectH = new Object();

	public void f() {
		synchronized (synObjectF) {
			super.f();
		}
	}

	public void g() {
		synchronized (synObjectG) {
			super.g();
		}
	}

	public void h() {
		synchronized (synObjectH) {
			super.h();
		}
	}
}

public class Ex15 {
	static void testCase(final Ex15Demo demo) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new Runnable() {
			@Override
			public void run() {
				demo.f();
			}
		});
		service.execute(new Runnable() {
			@Override
			public void run() {
				demo.g();
			}
		});
		service.execute(new Runnable() {
			@Override
			public void run() {
				demo.h();
			}
		});
		service.shutdown();
	}

	public static void main(String[] args) {
		//		testCase(new Ex15Demo1());
		testCase(new Ex15Demo2());
	}
}
