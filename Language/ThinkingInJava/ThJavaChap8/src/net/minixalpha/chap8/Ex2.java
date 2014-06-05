/**
 * @author minix
 * @Date Jun 10, 2013 23:05:27 PM
 * @Description
 *		Exercise 2: (1) Add the @Override annotation to the shapes example
 */
package net.minixalpha.chap8;

class Shape {
	  public void draw() {}
	  public void erase() {}
}

class Square extends Shape {
	  @Override public void draw() { System.out.println("Square.draw()"); }
	  @Override public void erase() { System.out.print("Square.erase()"); }
}

class Triangle extends Shape {
	@Override public void draw() { System.out.println("Triangle.draw()"); }
	@Override public void erase() { System.out.println("Triangle.erase()"); }
} 

class Circle extends Shape {
	@Override public void draw() { System.out.println("Circle.draw()"); }
	@Override public void erase() { System.out.println("Circle.erase()"); }
}

public class Ex2 {
	public static void main(String[] args) {
		
	}
}
