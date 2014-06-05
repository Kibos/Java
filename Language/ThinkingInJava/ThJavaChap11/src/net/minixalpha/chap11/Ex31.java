package net.minixalpha.chap11;

import java.util.Iterator;
import java.util.Random;

import net.minixalpha.chap11.shape.Circle;
import net.minixalpha.chap11.shape.Shape;
import net.minixalpha.chap11.shape.Square;
import net.minixalpha.chap11.shape.Triangle;

class RandomShapeGenerator implements Iterable<Shape> {
	private Random rand = new Random(47);
	private int num;
	private int index;

	public RandomShapeGenerator(int num) {
		this.num = num;
		this.index = 0;
	}

	@Override
	public Iterator<Shape> iterator() {
		return new Iterator<Shape>() {

			@Override
			public boolean hasNext() {
				return index < num;
			}

			@Override
			public Shape next() {
				index++;
				switch (rand.nextInt(3)) {
				default:
				case 0:
					return new Circle();
				case 1:
					return new Square();
				case 2:
					return new Triangle();
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}

public class Ex31 {

	public static void main(String[] args) {
		RandomShapeGenerator shapeGen = new RandomShapeGenerator(5);
		Iterator<Shape> shapIterator = shapeGen.iterator();

		while (shapIterator.hasNext()) {
			Shape shape = shapIterator.next();
			shape.draw();
		}
	}

}
