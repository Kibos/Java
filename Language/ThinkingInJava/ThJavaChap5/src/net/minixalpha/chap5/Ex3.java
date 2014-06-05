/**
 * @author minix
 * @Date Apr 4, 2013 2:00:26 PM
 * @Description
 *		Exercise 3: (1) Create a class with a default constructor (one that takes no arguments)
 *		that prints a message. Create an object of this class.
 */

package net.minixalpha.chap5;

class TestClass {
	TestClass() {
		System.out.println("I'm default constructor without argument");
	}
}

public class Ex3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestClass tc = new TestClass();
//		tc.TestClass(); You can not invoke constructor explicitly
	}
}

/*
Output:
I'm default constructor without argument
*/