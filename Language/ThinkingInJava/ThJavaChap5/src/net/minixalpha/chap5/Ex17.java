/**
 * @author minix
 * @Date Apr 10, 2013 12:29:06 PM
 * @Description
 *		Exercise 17: (2) Create a class with a constructor that takes a String argument. During
 *		construction, print the argument. Create an array of object references to this class, but don’t
 *		actually create objects to assign into the array. When you run the program, notice whether
 *		the initialization messages from the constructor calls are printed.
 */

package net.minixalpha.chap5;

class TestArrayInit {
	TestArrayInit(String[] strArray) {
		for (int i=0; i<strArray.length; i++) {
			System.out.print(strArray[i]);
		}
	}
}

public class Ex17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestArrayInit[] tar;
	}
}

/**
Output:
(null)
*/