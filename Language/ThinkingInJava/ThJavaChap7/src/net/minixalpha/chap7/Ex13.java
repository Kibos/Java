/**
 * @author minix
 * @Date May 14, 2013 5:10:59 PM
 * @Description
 *		Exercise 13: (2) Create a class with a method that is overloaded three times. Inherit a
		new class, add a new overloading of the method, and show that all four methods are available
		in the derived class.
 */

package net.minixalpha.chap7;

class Ex13Root {
	void testOveride(int i) {
		System.out.println("testOveride in Ex13Root");
	}
}

class Ex13DerivedOne extends Ex13Root {
	void testOveride(float i) {
		System.out.println("testOveride in Ex13DerivedOne");
	}
}

class Ex13DerivedTwo extends Ex13DerivedOne {
	void testOveride(char c) {
		System.out.println("testOveride in Ex13DerivedTwo");
	}
}

class Ex13DerivedThree extends Ex13DerivedTwo {
	void testOveride(boolean d) {
		System.out.println("Ex13DerivedThree in Ex13DerivedTwo");
	}
}

class Ex13FinalDerived extends Ex13DerivedThree {
	void testOveride() {
		System.out.println("Ex13DerivedThree in Ex13FinalDerived");
	}

// Compile error: The method testOveride(Ex13DerivedThree) of type Ex13FinalDerived must override or 
//			      implement a supertype method
//	@Override void testOveride(Ex13DerivedThree i) {
//		System.out.println("Ex13DerivedThree in Ex13FinalDerived");
//	}
	
	// No compile error
	void testOveride(Ex13DerivedThree i) {
		System.out.println("Ex13DerivedThree in Ex13FinalDerived");
	}
	
	// No compile error
	@Override void testOveride(int  i) {
	System.out.println("Ex13DerivedThree in Ex13FinalDerived");
}
	
	
}

public class Ex13 {
	public static void main(String[] args) {
		Ex13FinalDerived ex13fd = new Ex13FinalDerived();
		ex13fd.testOveride();
		ex13fd.testOveride(true);
		ex13fd.testOveride('x');
		ex13fd.testOveride((float)1.2);
		ex13fd.testOveride(7);
		
		Ex13Root ex13rt = new Ex13Root();
		ex13rt.testOveride(5);
	}
}

/**
Output:
Ex13DerivedThree in Ex13FinalDerived
Ex13DerivedThree in Ex13DerivedTwo
testOveride in Ex13DerivedTwo
testOveride in Ex13DerivedOne
Ex13DerivedThree in Ex13FinalDerived
testOveride in Ex13Root
*/