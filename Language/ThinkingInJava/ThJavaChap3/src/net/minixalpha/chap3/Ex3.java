/**
 * Exercise 3: (1) Create a class containing a float and use it to demonstrate aliasing during
 * method calls.
 */
package net.minixalpha.chap3;

import static net.mindview.util.Print.*;

/**
 * Point:
 * 	1. Show the tech of aliasing
 *  2. Java regards argument as reference, not a copy 
 * @author minix
 *
 */

class testAlias {
	float tAlias;
}
public class Ex3 {
	static void f(testAlias t) {
		t.tAlias = 3.4F;
	}
	
	public static void main(String[] args) {
		testAlias p = new testAlias();
		p.tAlias = 1.526F;
		print ("p's field tAlias is " + p.tAlias);
		
		f(p);
		print ("After f(p), ");
		print ("p's field tAlias is " + p.tAlias);
	}
}

/**
 * Output:
 * p's field tAlias is 1.526
 * After f(p), 
 * p's field tAlias is 3.4
 * 
 */
