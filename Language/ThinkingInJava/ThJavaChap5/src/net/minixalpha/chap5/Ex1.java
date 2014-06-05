/**
 * @author minix
 * @Date Apr 3, 20132:44:06 PM
 * @Description
 * 		Exercise 1: (1) Create a class containing an uninitialized String reference. Demonstrate
 *		that this reference is initialized by Java to null.
 */

package net.minixalpha.chap5;

class TestStringInit {
	String strNoInit;
}

public class Ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestStringInit tsi = new TestStringInit();
		System.out.println(tsi.strNoInit);
	}
}

/**
Output:
null
*/