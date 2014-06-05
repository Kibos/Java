package net.minixalpha.chap14;

import java.util.Arrays;
import java.util.List;

public class Ex5 {
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
		
		public void rotate(Shape shape) {
			if ((shape instanceof Circle) == false) {
				System.out.println("hijack");
			}
		}
		
		public void main(String[] args) {
			Shape shape = new Rhomboid();
			Shape shape2 = new Circle();
			rotate(shape);
			rotate(shape2);
		}
	}

	public static void main(String[] args) {
		Ex5 ex5 = new Ex5();
		Shapes shape = ex5.new Shapes();
		shape.main(null);
	}

}
