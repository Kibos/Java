/**
 * @author 
 * @Date Jun 17, 2013 4:51:28 PM
 * @Description
 * 	Create a base class with two methods. In the first method, call the
	second method. Inherit a class and override the second method. Create an object of the
	derived class, upcast it to the base type, and call the first method. Explain what happens.

 */
package net.minixalpha.chap8;

class BaseEx10 {
	void foo() {
		bar();
	}
	
	void bar() {
		System.out.println("bar");
	}
}

class Extends10 extends BaseEx10 {
	void bar() {
		System.out.println("bar of extends10");
	}
}

public class Ex10 {
	public static void main(String[] args) {
		Extends10 ex10 = new Extends10();
		ex10.foo();
	}
}

/**
 * Output:
 * bar of extends10
 */

/**
 * Invoke inherit class's methodp
 */
