/**
 * @author minix
 * @Date Jun 10, 2013 23:05:27 PM
 * @Description
 *		Exercise 4: (2) Add a new type of Shape to Shapes.java and verify in main( ) that
		polymorphism works for your new type as it does in the old types.
 */

package net.minixalpha.chap8;

import java.util.Random;

class MyShape extends Shape {
	@Override
	public void draw() {
		System.out.println("MyShape.draw()");
	}

	@Override
	public void erase() {
		System.out.print("MyShape.erase()");
	}
}

class RandomShapeGenerator {
	private Random rand = new Random();

	public Shape next() {
		switch (rand.nextInt(4)) {
		default:
		case 0:
			return new Circle();
		case 1:
			return new Square();
		case 2:
			return new Triangle();
		case 3:
			return new MyShape();
		}
	}
}

public class Ex4 {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();

	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		for (int i = 0; i < s.length; i++)
			s[i] = gen.next();
		for (Shape shp : s)
			shp.draw();
	}

}

/**
Output:
Square.draw()
Square.draw()
MyShape.draw()
Triangle.draw()
Circle.draw()
Triangle.draw()
MyShape.draw()
Square.draw()
MyShape.draw()
*/