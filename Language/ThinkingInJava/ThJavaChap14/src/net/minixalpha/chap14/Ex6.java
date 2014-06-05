package net.minixalpha.chap14;

import java.util.Arrays;
import java.util.List;

public class Ex6 {
	abstract class Shape {
		int flag = 0;

		public Shape() {
			String curClassName = this.getClass().getSimpleName();
			if (curClassName.equals("Circle")) {
				flag = 1;
			}
		}

		void draw() {
			System.out.println(this + "is a circle " + flag);
		}

		public String toString() {
			Class c = this.getClass();
			return c.getSimpleName();
		}
	}

	class Circle extends Shape {

	}

	class Square extends Shape {
	}

	class Triangle extends Shape {

	}

	class Shapes {

		public void main(String[] args) {
			List<Shape> shapeList = Arrays.asList(new Circle(), new Square(),
					new Triangle());
			for (Shape shape : shapeList)
				shape.draw();
		}
	}

	public static void main(String[] args) {
		Ex6 ex6 = new Ex6();
		Shapes shape = ex6.new Shapes();
		shape.main(null);
	}

}
