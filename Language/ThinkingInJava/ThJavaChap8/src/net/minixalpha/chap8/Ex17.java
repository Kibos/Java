package net.minixalpha.chap8;

class Cycle2 {
	void ride() {
		System.out.println("ride Cycle2");
	}
}

class Unicycle2 extends Cycle2 {
	void balance() {

	}

	void ride() {
		System.out.println("ride Uicycle2");
	}
}

class Bicycle2 extends Unicycle2 {
	void balance() {

	}

	void ride() {
		System.out.println("ride Bicycle2");
	}
}

class Ticycle2 extends Unicycle2 {
	void ride() {
		System.out.println("ride Ticycle2");
	}
}

public class Ex17 {
	static void ride(Cycle2 c) {
		c.ride();
	}

	public static void main(String[] args) {
		Cycle2[] cycles = { new Unicycle2(), new Bicycle2(), new Ticycle2() };

		// The method balance() is undefined for the type Cycle2
		// for(int i=0; i<cycles.length; i++) {
		// cycles[i].balance();
		// }

		((Unicycle2) cycles[0]).balance();
		((Bicycle2) cycles[1]).balance();
		((Ticycle2) cycles[2]).balance(); // Get balance from its parent
	}
}