package net.minixalpha.chap10;

interface Cycle {
	void foo();
}

interface CycleFactory {
	Cycle getCycle();
}

class Unicycle implements Cycle {
	public static CycleFactory factory = new CycleFactory() {

		@Override
		public Cycle getCycle() {
			return new Unicycle();
		}
	};

	public void foo() {
		System.out.println("Unicycle.foo");
	}
}

class Bicycle implements Cycle {
	public static CycleFactory factory = new CycleFactory() {

		@Override
		public Cycle getCycle() {
			return new Bicycle();
		}
	};

	public void foo() {
		System.out.println("Bicycle.foo");
	}
}

class Tricycle implements Cycle {
	public static CycleFactory factory = new CycleFactory() {

		@Override
		public Cycle getCycle() {
			return new Tricycle();
		}
	};

	public void foo() {
		System.out.println("Tricycle.foo");
	}
}

public class Ex16 {
	static void foo(CycleFactory tricycleFactory) {
		Cycle cycle = tricycleFactory.getCycle();
		cycle.foo();
	}

	public static void main(String[] args) {
		foo(Unicycle.factory);
		foo(Bicycle.factory);
		foo(Tricycle.factory);
	}
}
