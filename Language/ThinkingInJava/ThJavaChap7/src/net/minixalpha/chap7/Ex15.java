/**
 * @author minix
 * @Date May 16, 2013 8:26:40 PM
 * @Description
 *		Exercise 15: (2) Create a class inside a package. Your class should contain a protected
		method. Outside of the package, try to call the protected method and explain the results.
		Now inherit from your class and call the protected method from inside a method of your
		derived class.
 */

package net.minixalpha.chap7;

import assistPkg.TestProtected;;

class GetProtected extends TestProtected {
	public void say() {
		super.say();
	}
}

public class Ex15 {
	public static void main(String[] args) {
		TestProtected tp = new TestProtected();
//		tp.say();The method say() from the type TestProtected is not visible
		
		GetProtected gp = new GetProtected();
		gp.say();
	}
}

/**Output:
I'm protected
*/