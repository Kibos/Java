package net.minixalpha.chap14;

import generics.coffee.*;

public class Ex12 {

	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Coffee.class);
		for (Coffee c : new CoffeeGenerator(5)) {
			counter.count(c);
		}
		System.out.println();
		System.out.println(counter);
	}

}
