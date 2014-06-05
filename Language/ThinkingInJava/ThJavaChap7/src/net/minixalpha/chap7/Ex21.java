/**
 * @author minix
 * @Date Jun 10, 2013 10:34:57 PM
 * @Description
 *		Create a class with a final method. Inherit from that class and attempt
		to overwrite that method
 */
package net.minixalpha.chap7;

class FinalMethod {
	final void finalMethod() {
		
	}
}

class TestFinalMethod extends FinalMethod {
	//Cannot override the final method from FinalMethod
//	final void finalMethod() {
//		
//	}
}

public class Ex21 {
	public static void main(String[] args) {
		
	}
}
