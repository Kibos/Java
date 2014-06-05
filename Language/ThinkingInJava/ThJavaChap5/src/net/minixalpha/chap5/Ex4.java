/**
 * @author minix
 * @Date Apr 4, 2013 2:04:15 PM
 * @Description
 *		Exercise 4: (1) Add an overloaded constructor to the previous exercise that takes a
 *		String argument and prints it along with your message.
 */

package net.minixalpha.chap5;


class TestClassOver {
	TestClassOver() {
		System.out.println("I'm default constructor without argument");
	}
	TestClassOver(String s) {
		System.out.println("I'm default constructor without argument");
		System.out.println(s);
	}
}
public class Ex4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Constructor without argument");
		TestClassOver tcn = new TestClassOver();
		System.out.println();
		
		String str = "I'm a tester";
		System.out.println("Constructor with argument: " + str);
		TestClassOver tcy = new TestClassOver(str);
		

	}
}

/*
Output:
Constructor without argument
I'm default constructor without argument

Constructor with argument: I'm a tester
I'm default constructor without argument
I'm a tester
*/