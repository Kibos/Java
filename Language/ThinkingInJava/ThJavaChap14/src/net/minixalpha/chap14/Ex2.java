package net.minixalpha.chap14;

import net.minixalpha.chap14.Ex2.ToyTest;

public class Ex2 {

	interface HasBatteries {
	}

	interface Waterproof {
	}

	interface Shoots {
	}
	
	interface Foo {
	}

	class Toy {
		// Comment out the following default constructor
		// to see NoSuchMethodError from (*1*)
		Toy() {
		}

		Toy(int i) {
		}
	}

	class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Foo {
		FancyToy() {
			super(1);
		}
	}

	class ToyTest {
		void printInfo(Class cc) {
			System.out.println("Class name: " + cc.getName()
					+ " is interface? [" + cc.isInterface() + "]");
			System.out.println("Simple name: " + cc.getSimpleName() + "********");
			System.out.println("Canonical name : " + cc.getCanonicalName());
		}

		public void main(String[] args) {
			Class c = null;
			try {
				c = Class.forName("net.minixalpha.chap14.Ex2$FancyToy");
			} catch (ClassNotFoundException e) {
				System.out.println("Can't find FancyToy");
				System.exit(1);
			}
			printInfo(c);
			for (Class face : c.getInterfaces())
				printInfo(face);
			Class up = c.getSuperclass();
			Object obj = null;
			try {
				// Requires default constructor:
				obj = up.newInstance();
			} catch (InstantiationException e) {
				System.out.println("Cannot instantiate");
				System.exit(1);
			} catch (IllegalAccessException e) {
				System.out.println("Cannot access");
				System.exit(1);
			}
			printInfo(obj.getClass());
		}
	}

	public static void main(String[] args) {
		Ex2 ex1 = new Ex2();
		ToyTest toyTest = ex1.new ToyTest();
		toyTest.main(null);
	}

}
/**
 * Simple name: Foo********
 * Canonical name : net.minixalpha.chap14.Ex2.Foo
 * Cannot instantiate
*/
