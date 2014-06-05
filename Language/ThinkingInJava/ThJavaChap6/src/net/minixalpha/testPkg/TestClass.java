/**
 * @author minix
 * @Date May 6, 2013 17:32 PM
 * @Description
 * 		Used to test package and import by Ex1.java
 */
package net.minixalpha.testPkg;

public class TestClass {
	protected void testProtected() {
		System.out.println("I'm a protected methods");
	}
	
	public TestClass() {
		System.out.println("I'm constructor of TestClass in package net.minixalpha.testPkg");
	}
}
