package net.minixalpha.chap21;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ex16Demo {
	public void f() {

		for (int i = 0; i < 5; i++) {
			System.out.println("f()");
			Thread.yield();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

class Ex16Demo1 extends Ex16Demo {
	private Lock lockF = new ReentrantLock();
	private Lock lockG = new ReentrantLock();
	private Lock lockH = new ReentrantLock();

	public void f() {
		lockF.lock();
		try {
			super.f();
		} finally {
			lockF.unlock();
		}
	}

	public void g() {
		lockG.lock();
		try {
			super.g();
		} finally {
			lockG.unlock();
		}
	}

	public void h() {
		lockH.lock();
		try {
			super.h();
		} finally {
			lockH.unlock();
		}
	}
}

class Ex16Demo2 extends Ex16Demo {
	private Lock lock = new ReentrantLock();

	public void f() {
		lock.lock();
		try {
			super.f();
		} finally {
			lock.unlock();
		}
	}

	public void g() {
		lock.lock();
		try {
			super.g();
		} finally {
			lock.unlock();
		}
	}

	public void h() {
		lock.lock();
		try {
			super.h();
		} finally {
			lock.unlock();
		}
	}
}

public class Ex16 {
	static void testCase(final Ex16Demo demo) {
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
//		 testCase(new Ex16Demo1());
		testCase(new Ex16Demo2());
	}
}
