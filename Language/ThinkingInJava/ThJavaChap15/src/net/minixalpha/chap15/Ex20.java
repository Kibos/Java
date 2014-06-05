package net.minixalpha.chap15;

import org.omg.CORBA.PRIVATE_MEMBER;

interface Ex20DemoInterface {
	void foo();

	void bar();
}

class Ex20DemoClass implements Ex20DemoInterface {

	@Override
	public void foo() {
		System.out.println("foo");
	}

	@Override
	public void bar() {
		System.out.println("bar");
	}

	public void gae() {

	}

}

class Ex20DemoClass2 {

	public static <T extends Ex20DemoInterface> void foo(T x) {
		x.foo();
		x.bar();
	}
}

public class Ex20 {
	public static void main(String[] args) {
		Ex20DemoClass2.foo(new Ex20DemoClass());
	}
}
