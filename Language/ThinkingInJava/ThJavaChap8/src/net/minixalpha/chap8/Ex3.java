/**
 * @author minix
 * @Date Jun 10, 2013 23:05:27 PM
 * @Description
 *		Exercise 3: (1) Add a new method in the base class of Shapes.java that prints a
		message, but don’t override it in the derived classes. Explain what happens. Now override it
		in one of the derived classes but not the others, and see what happens. Finally, override it in
		all the derived classes.
 */
package net.minixalpha.chap8;

import java.util.Random;

class ShapeEx3 {
	  public void draw() {}
	  public void erase() {}
	  public void printMsg() {System.out.println("I'm shape");}
}

class SquareEx3 extends ShapeEx3 {
	  @Override public void draw() { System.out.println("Square.draw()"); }
	  @Override public void erase() { System.out.println("Square.erase()"); }
	  @Override public void printMsg() {System.out.println("I'm square"); }
}

class TriangleEx3 extends ShapeEx3 {
	@Override public void draw() { System.out.println("Triangle.draw()"); }
	@Override public void erase() { System.out.println("Triangle.erase()"); }
} 

class CircleEx3 extends ShapeEx3 {
	@Override public void draw() { System.out.println("Circle.draw()"); }
	@Override public void erase() { System.out.println("Circle.erase()"); }
}

public class Ex3 {
	public static void main(String[] args) {
		ShapeEx3[] shapes = {
				new SquareEx3(), new TriangleEx3(), new CircleEx3()
		};
		for (ShapeEx3 shape: shapes) {
			shape.draw();
			shape.erase();
			shape.printMsg();
		}
			
	}
}

/**
Output:
Square.draw()
Square.erase()
I'm square
Triangle.draw()
Triangle.erase()
I'm shape
Circle.draw()
Circle.erase()
I'm shape
*/