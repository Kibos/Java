package net.minixalpha.chap8;

class Rodent2 {
	public Rodent2() {
		System.out.println("Init Rodent2");
	}

	String className() {
		return "Rodent";
	}
}

class Mouse2 extends Rodent2 {
	public Mouse2() {
		System.out.println("Init Mouse2");
	}

	String className() {
		return "Mouse";
	}
}

class Gerbil2 extends Rodent2 {
	Mouse2 m = new Mouse2();

	public Gerbil2() {
		System.out.println("Init Gerbil2");
	}

	String className() {
		return "Gerbil";
	}
}

public class Ex12 {
	public static void main(String[] args) {
		Gerbil2 m = new Gerbil2();
	}

}
