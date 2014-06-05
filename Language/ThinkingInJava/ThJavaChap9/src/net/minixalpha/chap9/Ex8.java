package net.minixalpha.chap9;


interface FastFood {
	void say();
}

class Meal implements FastFood{
	public void say() {
		System.out.println("Meal()");
	}
}


class Lunch extends Meal {
	public void say() {
		System.out.println("Lunch()");
	}
}

class PortableLunch extends Lunch {
	public void say() {
		System.out.println("PortableLunch()");
	}
}

public class Ex8 {
	public static void main(String[] args) {
		PortableLunch portableLunch = new PortableLunch();
		portableLunch.say();
	}

}
