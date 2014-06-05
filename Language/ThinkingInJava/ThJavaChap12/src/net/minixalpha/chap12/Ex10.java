package net.minixalpha.chap12;

class Ex10Exp1 extends Exception {

}

class Ex10Exp2 extends Exception {

}

public class Ex10 {

	static void f() throws Ex10Exp2 {
		try {
			g();
		} catch (Ex10Exp1 e) {
			throw new Ex10Exp2();
		}
	}

	static void g() throws Ex10Exp1 {
		throw new Ex10Exp1();
	}

	public static void main(String[] args) throws Ex10Exp2 {
		f();
	}
}
