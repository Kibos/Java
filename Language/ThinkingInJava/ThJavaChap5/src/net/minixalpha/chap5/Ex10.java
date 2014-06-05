/**
 * @author minix
 * @Date Apr 6, 2013 4:26:40 PM
 * @Description
 *		Exercise 10: (2) Create a class with a finalize( ) method that prints a message. In
 *		main( ), create an object of your class. Explain the behavior of your program.
 */

package net.minixalpha.chap5;

class Book {
	int number;
	Book() {
		number = 1;
		System.out.println("I'm constructor");
	}
	
	Book(int num) {
		this.number = num;
	}
	
	protected void finalize() throws Throwable {
		number = 0;
		System.out.println("I'm finalize");
		super.finalize();
	}
}
public class Ex10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book b = new Book();
		Book bs = new Book(10);
		System.out.println("----------");
		System.gc();
	}
}

/*
Output:
I'm constructor
----------
*/