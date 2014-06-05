package net.minixalpha.chap15;

import java.util.*;

class Pet {
}

class Dog extends Pet {
}

public class Ex1 {
	public static void main(String[] args) {
		List<Pet> pets = new ArrayList<Pet>();
		pets.add(new Pet());
		pets.add(new Dog());
	}
}
