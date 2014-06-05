//: generics/coffee/Coffee.java
package generics.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import typeinfo.factory.Factory;

public class Coffee {
	private static long counter = 0;
	private final long id = counter++;

	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}

	static List<Factory<? extends Coffee>> coffeeFactories = new ArrayList<Factory<? extends Coffee>>();
	static {
		coffeeFactories.add(new Breve.Factory());
		coffeeFactories.add(new Latte.Factory());
	}

	private static Random random = new Random();

	public static Coffee randomCoffe() {
		int n = random.nextInt(coffeeFactories.size());
		return coffeeFactories.get(n).create();
	}
} // /:~
