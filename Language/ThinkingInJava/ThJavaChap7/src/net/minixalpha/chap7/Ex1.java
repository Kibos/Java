/**
 * @minix
 * @Date May 10, 2013 2:00:32 PM
 * @Desciption
 *		Exercise 1: (2) Create a simple class. Inside a second class, define a reference to an object
		of the first class. Use lazy initialization to instantiate this object.
		Assist class of Ex4
 */

package net.minixalpha.chap7;

class SimpleClass {
	public String toString() {
		return "simple class";
	}
}

public class Ex1 {
	SimpleClass sc;
	
	public String toString() {
		if (sc == null) {
			sc = new SimpleClass();
		}
		return sc.toString();
		
	}
	public static void main(String[] args) {
		Ex1 ex1 = new Ex1();
		System.out.println(ex1);
	}
}

/**
Output:
simple class
*/