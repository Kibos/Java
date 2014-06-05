package net.minixalpha.chap12;

import java.util.Random;

class Ex9Exp1 extends Exception {

}

class Ex9Exp2 extends Exception {

}

class Ex9Exp3 extends Exception {

}

public class Ex9 {

	static void foo(int i) throws Ex9Exp1, Ex9Exp2, Ex9Exp3 {
		if (i == 1) {
			throw new Ex9Exp1();
		} else if (i == 2) {
			throw new Ex9Exp2();
		} else {
			throw new Ex9Exp3();
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		try {
			foo(random.nextInt(3));
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}

}
