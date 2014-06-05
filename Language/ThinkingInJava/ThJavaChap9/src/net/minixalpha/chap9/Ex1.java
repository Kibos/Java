package net.minixalpha.chap9;


abstract class Rodent {
	public abstract void say();
	public void what() {
		System.out.println("Rodent");
	}
}

class Mouse extends Rodent {
	public void say() {
		System.out.println("I'm a mouse");
	}
}

class Gerbil extends Rodent {
	public void say() {
		System.out.println("I'm a Gerbil");
	}
	
	public void what() {
		System.out.println("Gerbil");
	}
}

public class Ex1 {
	public static void main(String[] args) {
		Rodent[] rodents = {
				new Mouse(),
				new Gerbil()
		};
		
		for (Rodent rodent:rodents) {
			rodent.what();
			rodent.say();
			System.out.println("---");
		}
	}
}
