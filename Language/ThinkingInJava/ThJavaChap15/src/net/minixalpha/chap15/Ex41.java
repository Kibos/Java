package net.minixalpha.chap15;

//: generics/Fill2.java
//Using adapters to simulate latent typing.
//{main: Fill2Test}
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

interface Addable<T> {
	void add(T t);
}

class Fill2 {
	// Classtoken version:
	public static <T> void fill(Addable<T> addable,
			Class<? extends T> classToken, int size) {
		for (int i = 0; i < size; i++)
			try {
				addable.add(classToken.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}

	// Generator version:
	public static <T> void fill(Addable<T> addable, Generator<T> generator,
			int size) {
		for (int i = 0; i < size; i++)
			addable.add(generator.next());
	}
}

// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
	private Collection<T> c;

	public AddableCollectionAdapter(Collection<T> c) {
		this.c = c;
	}

	public void add(T item) {
		c.add(item);
	}
}

// A Helper to capture the type automatically:
class Adapter {
	public static <T> Addable<T> collectionAdapter(Collection<T> c) {
		return new AddableCollectionAdapter<T>(c);
	}
}

// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance:
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
	public void add(T item) {
		super.add(item);
	}
}

class Pet41 {
}

class Dog41 extends Pet41 {

}

class Cat41 extends Pet41 {

}

class Fill2Test {
	public static void main(String[] args) {
		// Adapt a Collection:
		List<Pet41> carrier = new ArrayList<Pet41>();
		Fill2.fill(new AddableCollectionAdapter<Pet41>(carrier), Pet41.class, 3);
		// Helper method captures the type:
		Fill2.fill(Adapter.collectionAdapter(carrier), Dog41.class, 2);
		for (Pet41 c : carrier)
			print(c);

		print("----------------------");

		// Use an adapted class:
		AddableSimpleQueue<Pet41> coffeeQueue = new AddableSimpleQueue<Pet41>();
		Fill2.fill(coffeeQueue, Cat41.class, 4);
		Fill2.fill(coffeeQueue, Dog41.class, 1);
		for (Pet41 c : coffeeQueue)
			print(c);
	}
} /*
 * Output: Coffee 0 Coffee 1 Coffee 2 Latte 3 Latte 4 ----------------------
 * Mocha 5 Mocha 6 Mocha 7 Mocha 8 Latte 9
 */// :~

public class Ex41 {
	public static void main(String[] args) {
		Fill2Test.main(null);
	}
}
