/**
 * @author minix
 * @Date Jun 10, 2013 23:05:27 PM
 * @Description
 *		Exercise 5: (1) Starting from Exercise 1, add a wheels( ) method in Cycle, which
		returns the number of wheels. Modify ride( ) to call wheels( ) and verify that
		polymorphism works
 */
package net.minixalpha.chap8;

class CycleEx5 {
	void ride() {
		System.out.println("wheel num:" + wheel());
	}
	int wheel() {
		return 1;
	}
}

class UnicycleEx5 extends CycleEx5 {
	void ride() {
		System.out.println("wheel num:" + wheel());
	}
	int wheel() {
		return 2;
	}
}

class BicycleEx5 extends CycleEx5 {
	void ride() {
		System.out.println("wheel num:" + wheel());
	}
	int wheel() {
		return 3;
	}
}
public class Ex5 {
	static void ride(CycleEx5 c) {
		System.out.println("wheel num:" + c.wheel());
	}
	
	public static void main(String[] args) {
		CycleEx5 cu = new UnicycleEx5();
		CycleEx5 bu = new BicycleEx5();
		
		ride(cu);
		ride(bu);
	}
}

/**
Output:
wheel num:2
wheel num:3
*/