package net.minixalpha.chap14;

import java.util.Arrays;
import java.util.List;

public class Ex3 {
	abstract class Shape {
		void draw() {
			System.out.println(this + ".draw()");
		}

		abstract public String toString();
	}

	class Circle extends Shape {
		public String toString() {
			return "Circle";
		}
	}

	class Square extends Shape {
		public String toString() {
			return "Square";
		}
	}

	class Triangle extends Shape {
		public String toString() {
			return "Triangle";
		}
	}

	class Rhomboid extends Shape {
		public String toString() {
			return "Rhomboid";
		}
	}

	class Shapes {
		public void main(String[] args) {
			Shape shape = new Rhomboid();
			Rhomboid rhomboid = (Rhomboid) shape;
			// Circle circle = (Circle)shape;
			/**
			 * Exception in thread "main" java.lang.ClassCastException:
			 * net.minixalpha.chap14.Ex3$Rhomboid cannot be cast to
			 * net.minixalpha.chap14.Ex3$Circle at
			 * net.minixalpha.chap14.Ex3$Shapes.main(Ex3.java:43) at
			 * net.minixalpha.chap14.Ex3.main(Ex3.java:50)
			 */
		}
	}

	public static void main(String[] args) {
		Ex3 ex3 = new Ex3();
		Shapes shape = ex3.new Shapes();
		shape.main(null);
	}

}
