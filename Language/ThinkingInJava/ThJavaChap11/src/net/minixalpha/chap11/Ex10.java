package net.minixalpha.chap11;

import java.util.ArrayList;

class Rodent {
	String className() {
		return "Rodent";
	}
}

class Mouse extends Rodent {
	String className() {
		return "Mouse";
	}
}

class Gerbils extends Rodent {
	String className() {
		return "Gerbil";
	}
}

public class Ex10 {

	public static void main(String[] args) {
		ArrayList<Rodent> rodents = new ArrayList<Rodent>();
		rodents.add(new Mouse());
		rodents.add(new Gerbils());

		for (Rodent rodent : rodents) {
			System.out.println(rodent.className());
		}
	}
}
