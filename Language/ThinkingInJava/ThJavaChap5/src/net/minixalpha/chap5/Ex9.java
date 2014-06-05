/**
 * @author minix
 * @Date Apr 5, 2013 2:33:20 PM
 * @Description
 *		Exercise 9: (1) Create a class with two (overloaded) constructors. Using this, call the
 *		second constructor inside the first one.
 */

package net.minixalpha.chap5;

class TestConstructor {
	TestConstructor() {
		System.out.println("I'm default constructor");
	}
	
	TestConstructor(int i) {
//		this.TestConstructor(); compile error
		this(); // invoke default constructor
		System.out.println("I'm constructor with argument " + i);
//		this(); // Constructor call must be the first statement in a constructor
	}
}
public class Ex9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestConstructor tc = new TestConstructor(8);
		
	}
}

/**
Output:
I'm default constructor
I'm constructor with argument 8
*/