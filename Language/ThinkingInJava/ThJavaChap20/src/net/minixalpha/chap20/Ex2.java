package net.minixalpha.chap20;


@ExtractInterface("IMultiplier2")
class Multiplier2 {
	public int multiply(int x, int y) {
		int total = 0;
		for (int i = 0; i < x; i++)
			total = add(total, y);
		return total;
	}

	private int add(int x, int y) {
		return x + y;
	}

	public static void main(String[] args) {
		Multiplier m = new Multiplier();
		System.out.println("11*16 = " + m.multiply(11, 16));
	}
}

public class Ex2 {
	// As Thinking in Java's source code is too old,
	// Most types in the files needed for this exercise
	// are not supported in JDK7, so I can't provide a 
	// compilable version to test the result
	
	// I try to find the replacement API, but can not find
	// all of them.
}
