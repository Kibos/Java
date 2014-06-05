package net.minixalpha.chap8;

class Rodent3 {
	private int refCount = 0;

	public Rodent3() {
		System.out.println("Init Rodent3");
	}

	String className() {
		return "Rodent";
	}

	public void addRef() {
		refCount++;
	}

	public int getRef() {
		return refCount;
	}
}

class Mouse3 extends Rodent3 {
	public Mouse3() {
		System.out.println("Init Mouse3");
	}

	String className() {
		return "Mouse";
	}
}

class Gerbil3 extends Rodent3 {
	Mouse3 m = new Mouse3();

	public Gerbil3() {
		System.out.println("Init Gerbil3");
	}

	String className() {
		return "Gerbil";
	}
}

class DemoEx14 {
	Rodent3 rodent3;

	public DemoEx14(Rodent3 rodent3) {
		this.rodent3 = rodent3;
		this.rodent3.addRef();
	}
}

public class Ex14 {
	public static void main(String[] args) {
		Rodent3 rodent3 = new Rodent3();
		new DemoEx14(rodent3);
		new DemoEx14(rodent3);
		System.out.println(rodent3.getRef());
	}
}
