package net.minixalpha.chap16;

import java.util.Arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.CountingGenerator.Character;
import net.mindview.util.RandomGenerator;
import static net.mindview.util.Print.*;

class SkipGenerator {
	private int step;

	public SkipGenerator(int step) {
		this.step = step;
	}

	public static class Boolean implements Generator<java.lang.Boolean> {
		private boolean value = false;
		private int step = 0;

		public Boolean(int step) {
			this.step = step;
		}

		public java.lang.Boolean next() {
			if (step % 2 != 0)
				value = !value; // Just flips back and forth
			return value;
		}
	}

	public static class Byte implements Generator<java.lang.Byte> {
		private byte value = 0;
		private int step = 0;

		public Byte(int step) {
			this.step = step;
		}

		public java.lang.Byte next() {
			value += step;
			return value;
		}
	}

	static char[] chars = ("abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

	public static class Character implements Generator<java.lang.Character> {
		int index = -1;

		private int step = 0;

		public Character(int step) {
			this.step = step;
		}

		public java.lang.Character next() {
			index = (index + step) % chars.length;
			return chars[index];
		}
	}

	public static class String implements Generator<java.lang.String> {
		private int length = 7;
		Generator<java.lang.Character> cg = null;

		private int step = 0;

		public String(int step) {
			this.step = step;
			this.cg = new Character(step);
		}

		public String(int length, int step) {
			this.length = length;
		}

		public java.lang.String next() {
			char[] buf = new char[length];
			for (int i = 0; i < length; i++)
				buf[i] = cg.next();
			return new java.lang.String(buf);
		}
	}

	public static class Short implements Generator<java.lang.Short> {
		private short value = 0;

		private int step = 0;

		public Short(int step) {
			this.step = step;
		}

		public java.lang.Short next() {
			value += step;
			return value;
		}
	}

	public static class Integer implements Generator<java.lang.Integer> {
		private int value = 0;

		private int step = 0;

		public Integer(int step) {
			this.step = step;
		}

		public java.lang.Integer next() {
			value += step;
			return value;
		}
	}

	public static class Long implements Generator<java.lang.Long> {
		private long value = 0;

		private int step = 0;

		public Long(int step) {
			this.step = step;
		}

		public java.lang.Long next() {
			value += step;
			return value;
		}
	}

	public static class Float implements Generator<java.lang.Float> {
		private float value = 0;

		private int step = 0;

		public Float(int step) {
			this.step = step;
		}

		public java.lang.Float next() {
			float result = value;
			value += step;
			return result;
		}
	}

	public static class Double implements Generator<java.lang.Double> {
		private double value = 0.0;

		private int step = 0;

		public Double(int step) {
			this.step = step;
		}

		public java.lang.Double next() {
			double result = value;
			value += step;
			return result;
		}
	}
}

public class Ex16 {
	 public static int size = 10;
	  public static void test(Class<?> surroundingClass) {
	    for(Class<?> type : surroundingClass.getClasses()) {
	      System.out.print(type.getSimpleName() + ": ");
	      try {
	        Generator<?> g = (Generator<?>) type.getConstructor(int.class).newInstance(3);
	        for(int i = 0; i < size; i++)
	          System.out.printf(g.next() + " ");
	        System.out.println();
	      } catch(Exception e) {
	        throw new RuntimeException(e);
	      }
	    }
	  }
	  public static void main(String[] args) {
	    test(SkipGenerator.class);
	  }
}
