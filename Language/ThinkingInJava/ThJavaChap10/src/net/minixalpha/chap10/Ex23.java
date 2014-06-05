package net.minixalpha.chap10;

interface U {
	void foo();

	void bar();

	void gae();
}

class A {
	U vFoo() {
		return new U() {

			@Override
			public void foo() {
				System.out.println("foo");
			}

			@Override
			public void bar() {
				System.out.println("bar");
			}

			@Override
			public void gae() {
				System.out.println("gae");
			}

		};

	}
}

class B {
	U[] itemsUs;

	B(int size) {
		itemsUs = new U[size];
	}

	B() {
		this(10);
	}

	int store(int i, U u) {
		if (i < 0 || i >= itemsUs.length) {
			return -1;
		} else {
			itemsUs[i] = u;
			return i;
		}

	}

	int clear(int i) {
		if (i < 0 || i >= itemsUs.length) {
			return -1;
		} else {
			itemsUs[i] = null;
			return i;
		}
	}
	
	void iter() {
		for(U u: itemsUs) {
			u.bar();
			u.foo();
			u.gae();
			System.out.println();
		}
	}
}

public class Ex23 {

	public static void main(String[] args) {
		A[] as = {
				new A(),
				new A(),
				new A()
		};
		
		B b = new B(as.length);
		
		for (int i=0; i<as.length; i++) {
			b.store(i, as[i].vFoo());
		}
		
		b.iter();
		
		for (int i=0; i<as.length; i++) {
			b.clear(i);
		}
		
	}

}
