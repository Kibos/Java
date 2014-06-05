package net.minixalpha.chap15;

import java.lang.reflect.*;
import java.util.*;

import static net.mindview.util.Print.*;

class PetEx40 {
	public void speak() {
		System.out.println("Pet speak");
	}
}


class DogEx40 extends PetEx40 {
	public void speak() { // MUST be public
		System.out.println("Dog speak");
	}
}

class CatEx40 extends PetEx40 {
	public void speak() {
		System.out.println("Cat speak");
	}
}

class Apply {
	public static <T, S extends Iterable<? extends T>> void apply(S seq,
			Method f, Object... args) {
		try {
			for (T t : seq)
				f.invoke(t, args);
		} catch (Exception e) {
			// Failures are programmer errors
			throw new RuntimeException(e);
		}
	}
}

class Shape {
	public void rotate() {
		print(this + " rotate");
	}

	public void resize(int newSize) {
		print(this + " resize " + newSize);
	}
}

class Square extends Shape {
}

class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			for (int i = 0; i < size; i++)
				// Assumes default constructor:
				add(type.newInstance());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class SimpleQueue<T> implements Iterable<T> {
	private LinkedList<T> storage = new LinkedList<T>();

	public void add(T t) {
		storage.offer(t);
	}

	public T get() {
		return storage.poll();
	}

	public Iterator<T> iterator() {
		return storage.iterator();
	}
}

class ApplyTest {

	static void applyPet() throws Exception {
		List<PetEx40> pets = new ArrayList<PetEx40>();
		for (int i = 0; i < 2; i++) {
			pets.add(new PetEx40());
		}
		Apply.apply(pets, PetEx40.class.getMethod("speak"));
		
		List<DogEx40> dogs = new ArrayList<DogEx40>();
		for (int i=0; i < 2; i++) {
			dogs.add(new DogEx40());
		}
		Apply.apply(dogs, DogEx40.class.getMethod("speak"));

	}

	static void applyShape() throws Exception {
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0; i < 10; i++)
			shapes.add(new Shape());
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
		List<Square> squares = new ArrayList<Square>();
		for (int i = 0; i < 10; i++)
			squares.add(new Square());
		Apply.apply(squares, Shape.class.getMethod("rotate"));
		Apply.apply(squares, Shape.class.getMethod("resize", int.class), 5);

		Apply.apply(new FilledList<Shape>(Shape.class, 10),
				Shape.class.getMethod("rotate"));
		Apply.apply(new FilledList<Shape>(Square.class, 10),
				Shape.class.getMethod("rotate"));

		SimpleQueue<Shape> shapeQ = new SimpleQueue<Shape>();
		for (int i = 0; i < 5; i++) {
			shapeQ.add(new Shape());
			shapeQ.add(new Square());
		}
		Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
	}

	public static void main(String[] args) throws Exception {
		applyPet();
	}
} /* (Execute to see output) */// :~

public class Ex40 {
	public static void main(String[] args) {

	}
}
