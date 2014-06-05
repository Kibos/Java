//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package net.minixalpha.chap14.pets;

import java.util.*;

import net.minixalpha.chap14.Ex15;

public class Pets {
	public static final PetCreator creator = new Ex15();

	public static Pet randomPet() {
		return creator.randomPet();
	}

	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}

	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
} // /:~
