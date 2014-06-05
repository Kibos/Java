/**
 * @author minix
 * @Date Apr 9, 2013 4:40:11 PM
 * @Description
 *		Exercise 15: (1) Create a class with a String that is initialized using instance
 *		initialization.
 */

package net.minixalpha.chap5;


class TestInstanceInit {
	String testVar;
	{
		testVar = "tmp";
	}
}

public class Ex15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestInstanceInit tii = new TestInstanceInit();
		System.out.println(tii.testVar);
	}
}

/**
Output:
tmp
*/