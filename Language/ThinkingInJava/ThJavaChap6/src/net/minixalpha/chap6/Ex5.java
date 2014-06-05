/**
 * @minix
 * @Date May 8, 2013 1:57:39 PM
 * @Desciption
 *		Exercise 5: (2) Create a class with public, private, protected, and package-access
 *		fields and method members. Create an object of this class and see what kind of compiler
 *		messages you get when you try to access all the class members. Be aware that classes in the
 *		same directory are part of the “default” package.
 */

package net.minixalpha.chap6;
class testAccess {
	public void testPublic() {
		System.out.println("I'm a public method");
	}
	
	private void testPrivate() {
		System.out.println("I'm a Private method");
	}
	
	protected void testProtected() {
		System.out.println("I'm a protected method");
	}
	
	void testPkg() {
		System.out.println("I'm a pkg method");
	}
}

public class Ex5 {
	public static void main(String[] args) {
		testAccess ta = new testAccess();
		ta.testPublic();
//		ta.testPrivate(); error: testPrivate() has private access in testAccess
		ta.testProtected();
		ta.testPkg();
	}
}

/**Output
I'm a public method
I'm a protected method
I'm a pkg method
*/