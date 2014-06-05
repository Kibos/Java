/**
 * @minix
 * @Date May 8, 2013 1:56:35 PM
 * @Desciption
 *		Exercise 4: (2) Show that protected methods have package access but are not public.
 */
package net.minixalpha.chap6;

import net.minixalpha.testPkg.*;

public class Ex4 {
	public static void main(String[] args) {
		TestClass tc = new TestClass();
//		tc.testProtected(); failure
	}
}
