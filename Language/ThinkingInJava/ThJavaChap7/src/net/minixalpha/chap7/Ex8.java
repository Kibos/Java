/**
 * @author minix
 * @Date May 12, 2013 5:58:09 PM
 * @Description
 *		Exercise 8: (1) Create a base class with only a non-default constructor, and a derived
		class with both a default (no-arg) and non-default constructor. In the derived-class
		constructors, call the base-class constructor.

 */

package net.minixalpha.chap7;

class Base {
	Base(int i) {
		System.out.println("Base's non-default constructor gets " + i);
	}
}

class Derive extends Base {
	Derive() {
		super(10);
		System.out.println("Derive's default constructor");
	}
	Derive(int i) {
		super(i);
		System.out.println("Derive's non-default constructor gets " + i);
	}
}

public class Ex8 {
	public static void main(String[] args) {
		Derive deriveDefault = new Derive();
		Derive deriveNonDefault = new Derive(13);
	}
}

/**Output:
Base's non-default constructor gets 10
Derive's default constructor
Base's non-default constructor gets 13
Derive's non-default constructor gets 13
*/