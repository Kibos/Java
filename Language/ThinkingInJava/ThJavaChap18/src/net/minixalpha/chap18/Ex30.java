package net.minixalpha.chap18;

import java.io.*;
import java.util.*;

abstract class Shape implements Serializable {
	public static final int RED = 1, BLUE = 2, GREEN = 3;
	private int xPos, yPos, dimension;
	private static Random rand = new Random(47);
	private static int counter = 0;
	private static int color;

	public abstract void setColor(int newColor);

	public abstract int getColor();

	public Shape(int xVal, int yVal, int dim) {
		xPos = xVal;
		yPos = yVal;
		dimension = dim;
	}

	public String toString() {
		return getClass() + "color[" + getColor() + "] xPos[" + xPos
				+ "] yPos[" + yPos + "] dim[" + dimension + "]\n";
	}

	public static Shape randomFactory() {
		int xVal = rand.nextInt(100);
		int yVal = rand.nextInt(100);
		int dim = rand.nextInt(100);
		switch (counter++ % 3) {
		default:
		case 0:
			return new Circle(xVal, yVal, dim);
		case 1:
			return new Square(xVal, yVal, dim);
		case 2:
			return new Line(xVal, yVal, dim);
		}
	}

}

class Circle extends Shape {
	private static int color = RED;

	public Circle(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}

	public static void serializeStaticState(ObjectOutputStream os)
			throws IOException {
		System.out.println(color);
		os.writeInt(color);
	}

	public static void deserializeStaticState(ObjectInputStream os)
			throws IOException {
		color = os.readInt();
	}
}

class Square extends Shape {
	private static int color;

	public Square(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		color = RED;
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}

	public static void serializeStaticState(ObjectOutputStream os)
			throws IOException {
		System.out.println(color);
		os.writeInt(color);
	}

	public static void deserializeStaticState(ObjectInputStream os)
			throws IOException {
		color = os.readInt();
	}
}

class Line extends Shape {
	private static int color = RED;

	public Line(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}

	public static void serializeStaticState(ObjectOutputStream os)
			throws IOException {
		System.out.println(color);
		os.writeInt(color);
	}

	public static void deserializeStaticState(ObjectInputStream os)
			throws IOException {
		color = os.readInt();
	}
}

class StoreCADState {
	public static void main(String[] args) throws Exception {
		List<Shape> shapes = new ArrayList<Shape>();
		// Make some shapes:
		for (int i = 0; i < 10; i++)
			shapes.add(Shape.randomFactory());
		// Set all the static colors to GREEN:
		for (int i = 0; i < 10; i++)
			((Shape) shapes.get(i)).setColor(Shape.GREEN);
		// Save the state vector:
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"CADState.out"));
		Circle.serializeStaticState(out);
		Square.serializeStaticState(out);
		Line.serializeStaticState(out);
		out.writeObject(shapes);
		// Display the shapes:
		System.out.println(shapes);
	}
}

public class Ex30 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"CADState.out"));
		// Read in the same order they were written:
		Circle.deserializeStaticState(in);
		Square.deserializeStaticState(in);
		Line.deserializeStaticState(in);
		List<Shape> shapes = (List<Shape>) in.readObject();
		System.out.println(shapes);
	}
}

/*
 * Serialize [class net.minixalpha.chap18.Circlecolor[3] xPos[58] yPos[55]
 * dim[93] , class net.minixalpha.chap18.Squarecolor[3] xPos[61] yPos[61]
 * dim[29] , class net.minixalpha.chap18.Linecolor[3] xPos[68] yPos[0] dim[22] ,
 * class net.minixalpha.chap18.Circlecolor[3] xPos[7] yPos[88] dim[28] , class
 * net.minixalpha.chap18.Squarecolor[3] xPos[51] yPos[89] dim[9] , class
 * net.minixalpha.chap18.Linecolor[3] xPos[78] yPos[98] dim[61] , class
 * net.minixalpha.chap18.Circlecolor[3] xPos[20] yPos[58] dim[16] , class
 * net.minixalpha.chap18.Squarecolor[3] xPos[40] yPos[11] dim[22] , class
 * net.minixalpha.chap18.Linecolor[3] xPos[4] yPos[83] dim[6] , class
 * net.minixalpha.chap18.Circlecolor[3] xPos[75] yPos[10] dim[42] ]
 */
