/**
 * @author minix
 * @Date May 6, 2013 17:32 PM
 * @Description
 * 		Exercise 1: (1) Create a class in a package. Create an instance of your class outside of that
 *		package.
 */
package net.minixalpha.chap6;

import net.minixalpha.testPkg.*;

public class Ex1 {
	public static void main(String[] args) {
		TestClass testClass = new TestClass();
	}
}

/**
Output:
I'm constructor of TestClass in package net.minixalpha.testPkg
*/