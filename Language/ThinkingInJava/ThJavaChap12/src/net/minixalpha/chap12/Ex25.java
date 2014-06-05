package net.minixalpha.chap12;

class Ex25Exp1 extends Exception {

}

class Ex25Exp2 extends Ex25Exp1 {

}

class Ex25Exp3 extends Ex25Exp2 {

}

class A {
	void foo() throws Ex25Exp1 {
		throw new Ex25Exp1();
	}
}

class B extends A {
	void foo() throws Ex25Exp2 {
		throw new Ex25Exp2();
	}
}

class C extends B {
	void foo() throws Ex25Exp3 {
		throw new Ex25Exp3();
	}
}

public class Ex25 {

	public static void main(String[] args) {
		A a = new C();
		try {
			a.foo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
