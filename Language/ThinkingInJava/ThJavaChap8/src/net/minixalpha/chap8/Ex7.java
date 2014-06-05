/**
 * @author 
 * @Date Jun 17, 2013 4:39:04 PM
 * @Description
 * 		Add a new type of Instrument to Music3.java and verify that
		polymorphism works for your new type

 */
package net.minixalpha.chap8;

class MyClass extends Instrument {
	public String toString() {
		return "MyClass";
	}
}

public class Ex7 {
	public static void main(String[] args) {
		Instrument insMyClass = new MyClass();
		System.out.println(insMyClass);
	}
}

/**
Output:
MyClass
*/