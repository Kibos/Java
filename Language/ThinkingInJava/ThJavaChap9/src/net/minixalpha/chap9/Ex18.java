
package net.minixalpha.chap9;

interface Cycle {
	void foo();
}

interface CycleFactory {
	Cycle getCycle();
}

class Unicycle implements Cycle {
	public void foo() {
		System.out.println("Unicycle.foo");
	}
}

class UnicycleFactory implements CycleFactory {
	public 	Cycle getCycle() {
		return new Unicycle();
	}
}

class Bicycle implements Cycle {
	public void foo() {
		System.out.println("Bicycle.foo");
	}
}


class BicycleFactory implements CycleFactory {
	public 	Cycle getCycle() {
		return new Bicycle();
	}
}


class Tricycle implements Cycle {
	public void foo() {
		System.out.println("Tricycle.foo");
	}
}

class TricycleFactory implements CycleFactory {
	public 	Cycle getCycle() {
		return new Tricycle();
	}
}

public class Ex18 {
	static void foo(CycleFactory tricycleFactory) {
		Cycle cycle = tricycleFactory.getCycle();
		cycle.foo();
	}
	
	public static void main(String[] args) {
		foo(new UnicycleFactory());
		foo(new BicycleFactory());
		foo(new TricycleFactory());
	}
}
