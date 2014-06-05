/**
 * @minix
 * @Date May 8, 2013 2:09:00 PM
 * @Desciption
 *		Exercise 6: (1) Create a class with protected data. Create a second class in the same file
 *		with a method that manipulates the protected data in the first class.
 */
package net.minixalpha.chap6;

class testProtectedData {
	public testProtectedData() {
		testProtected = 0;
	}
	protected int testProtected;
}

public class Ex6 {
	public static void manipulateProtectedData(testProtectedData tp) {
		tp.testProtected = tp.testProtected + 1;
	}
	
	public static void main(String[] args) {
		testProtectedData tp = new testProtectedData();
		System.out.println(tp.testProtected);
		manipulateProtectedData(tp);
		System.out.println(tp.testProtected);
	}
}

/**Output:
0
1
*/