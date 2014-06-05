/**
 * @author minix
 * @Date Apr 4, 2013 2:15:09 PM
 * @Description
 *		Exercise 7: (1) Create a class without a constructor, and then create an object of that
 *		class in main( ) to verify that the default constructor is automatically synthesized.
 */

package net.minixalpha.chap5;

class ClassNoContructor {
	void say() {
		System.out.println("I have no constructor");
	}
}

public class Ex7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassNoContructor cnc = new ClassNoContructor();
		cnc.say();
	}

}

/*
Output:
I have no constructor
*/