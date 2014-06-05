/**
 * @author minix
 * @Date Apr 10, 2013 12:33:41 PM
 * @Description
 *		Exercise 18: (1) Complete the previous exercise by creating objects to attach to the array
 *		of references.
 *		Exercise 17: (2) Create a class with a constructor that takes a String argument. During
 *		construction, print the argument. Create an array of object references to this class, but don’t
 *		actually create objects to assign into the array. When you run the program, notice whether
 *		the initialization messages from the constructor calls are printed.
 */

package net.minixalpha.chap5;

class TestArrayInitV {
	TestArrayInitV(String[] strArray) {
		for (int i=0; i<strArray.length; i++) {
			System.out.print(strArray[i] + " ");
		}
		System.out.println();
	}
}

public class Ex18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestArrayInitV[] tar = {
				new TestArrayInitV(new String[]{"unix", "apple", "linux"} ),
				new TestArrayInitV(new String[]{"vim", "emacs", "nano"} ),
		};
	}
}

/**
Output:
unix apple linux 
vim emacs nano 
*/