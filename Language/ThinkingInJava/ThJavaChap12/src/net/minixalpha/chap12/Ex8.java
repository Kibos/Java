package net.minixalpha.chap12;

import java.io.IOException;
import java.util.List;

public class Ex8 {

	// static void foo() {
	// throw new IOException();
	// }

	static void foo() {
		try {
			throw new IOException();
		} catch (IOException e) {

		}
	}

	static void foo2() throws IOException {
		throw new IOException();
	}

	static void bar() {
		throw new NullPointerException();
	}

	public static void main(String[] args) {
		bar();
		foo();
		try {
			foo2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
