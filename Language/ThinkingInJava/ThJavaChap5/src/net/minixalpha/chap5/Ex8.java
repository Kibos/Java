/**
 * @author minix
 * @Date Apr 5, 2013 2:28:19 PM
 * @Description
 *		Exercise 8: (1) Create a class with two methods. Within the first method, call the second
 *		method twice: the first time without using this, and the second time using this—just to see it
 *		working; you should not use this form in practice.
 */

package net.minixalpha.chap5;

class TestThis {
	void f1() {
		f2();
		this.f2();
	}
	
	void f2() {
		System.out.println("I'm method f2");
	}
}
public class Ex8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestThis tt = new TestThis();
		tt.f1();
	}
}

/**
Output:
I'm method f2
I'm method f2
*/