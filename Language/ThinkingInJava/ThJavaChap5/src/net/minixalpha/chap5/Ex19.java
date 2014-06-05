/**
 * @author minix
 * @Date Apr 11, 2013 8:07:07 PM
 * @Description
 *		Exercise 19: (2) Write a method that takes a vararg String array. Verify that you can
 *		pass either a comma-separated list of Strings or a String[] into this method.
 */

package net.minixalpha.chap5;

public class Ex19 {

	/**
	 * @param args
	 */
	static void testVarArg(String ...strings ) {
		for (String str: strings) {
			System.out.println(str + " ");
		}
	}
	public static void main(String[] args) {
		testVarArg("a", "b", "c");
		System.out.println("---");
		String[] tstr = {"d", "e", "f" };
		testVarArg(tstr);
	}
}

/*
Output:
a 
b 
c 
---
d 
e 
f 
*/