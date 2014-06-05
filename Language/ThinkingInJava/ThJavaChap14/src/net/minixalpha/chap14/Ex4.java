package net.minixalpha.chap14;

import java.util.Arrays;
import java.util.List;

public class Ex4 {
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
			Rhomboid rhomboid = (shape instanceof Rhomboid) ? (Rhomboid) shape: null;
			Circle circle = (shape instanceof Circle) ? (Circle)shape: null;
		}
	}

	public static void main(String[] args) {
		Ex4 ex4 = new Ex4();
		Shapes shape = ex4.new Shapes();
		shape.main(null);
	}

}
