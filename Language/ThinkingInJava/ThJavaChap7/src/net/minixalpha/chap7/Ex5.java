/**
 * @author minix
 * @Date May 12, 2013 5:44:54 PM
 * @Description
 *		Exercise 5: (1) Create two classes, A and B, with default constructors (empty argument
		lists) that announce themselves. Inherit a new class called C from A, and create a member of
		class B inside C. Do not create a constructor for C. Create an object of class C and observe
		the results.
 */

package net.minixalpha.chap7;

import static net.mindview.util.Print.*;
class A {
	A() { print ("A's constuctor"); }
}
class B {
	B() { print ("B's constructor"); }
}
class C extends A {
	B b = new B();
}
public class Ex5 {
	public static void main(String[] args) {
		C c = new C();
	}
}

/** Output:
A's constuctor
B's constructor
*/