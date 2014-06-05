package net.minixalpha.chap15;

interface Ex25InterfaceFoo {
	void foo();
}

interface Ex25InterfaceBar {
	void bar();
}

class Ex25Demo implements Ex25InterfaceBar, Ex25InterfaceFoo {

	@Override
	public void foo() {
		System.out.println("foo");
	}

	@Override
	public void bar() {
		System.out.println("bar");
	}

}

public class Ex25 {

	public static <T extends Ex25InterfaceBar> void bar(T a) {
		a.bar();
	}

	public static <T extends Ex25InterfaceFoo> void foo(T a) {
		a.foo();
	}

	public static void main(String[] args) {
		Ex25Demo demo = new Ex25Demo();
		bar(demo);
		foo(demo);
	}
}
