/**
 * @author minix
 * @Date Jun 10, 2013 10:48:27 PM
 * @Description
 *		Exercise 1: (2) Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
		Demonstrate that an instance of each type can be upcast to Cycle via a ride( ) method.
 */

package net.minixalpha.chap8;

class Cycle {
	void ride() {
		System.out.println("ride Cycle");
	}
}

class Unicycle extends Cycle {
	void ride() {
		System.out.println("ride Uicycle");
	}
}

class Bicycle extends Unicycle {
	void ride() {
		System.out.println("ride Bicycle");
	}
}

class Ticycle extends Unicycle {
	void ride() {
		System.out.println("ride Ticycle");
	}
}

public class Ex1 {
	static void ride(Cycle c) {
		c.ride();
	}
	
	public static void main(String[] args) {
		Unicycle uc = new Unicycle();
		Bicycle bc = new Bicycle();
		Ticycle tc = new Ticycle();
	
		Cycle cuc = new Unicycle();
		Cycle cbc = new Bicycle();
		Cycle ctc = new Ticycle();
		
		ride(uc);
		ride(bc);
		ride(tc);
		
		System.out.println("------------");
		
		ride(cuc);
		ride(cbc);
		ride(ctc);
		
	}
}

/**Output:
ride Uicycle
ride Bicycle
ride Ticycle
------------
ride Uicycle
ride Bicycle
ride Ticycle
*/