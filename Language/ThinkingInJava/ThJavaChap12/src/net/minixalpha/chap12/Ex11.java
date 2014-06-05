package net.minixalpha.chap12;

import javax.management.RuntimeErrorException;

class Ex11Exp1 extends Exception {

}

class Ex11Exp2 extends Exception {

}

public class Ex11 {

	static void f() {
		try {
			g();
		} catch (Ex10Exp1 e) {
			throw new RuntimeException(e);
		}
	}

	static void g() throws Ex10Exp1 {
		throw new Ex10Exp1();
	}

	public static void main(String[] args) throws Ex10Exp2 {
		f();
	}

}
