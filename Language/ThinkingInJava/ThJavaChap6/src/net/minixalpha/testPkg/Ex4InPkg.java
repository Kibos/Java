/**
 * @minix
 * @Date May 8, 2013 2:00:32 PM
 * @Desciption
 *		Assist class of Ex4
 */

package net.minixalpha.testPkg;

public class Ex4InPkg {

	public static void main(String[] args) {
		TestClass tc = new TestClass();
		tc.testProtected(); 
	}

}

/**Output:
I'm constructor of TestClass in package net.minixalpha.testPkg
I'm a protected methods
*/