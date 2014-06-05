package net.minixalpha.chap12;

import java.rmi.NoSuchObjectException;

class FooDemo1 extends Exception {

}

class FooDemo2 extends Exception {

}

public class Demo1 {

	static void foo() throws FooDemo2 {
		try {
			throw new FooDemo1();
		} catch (FooDemo1 e) {
			FooDemo2 demo2Exp = new FooDemo2();
			demo2Exp.initCause(new NullPointerException());
			throw demo2Exp;
		}
	}

	public static void main(String[] args) {
		try {
			foo();
		} catch (FooDemo2 e) {
			e.printStackTrace();
		}
	}

}
