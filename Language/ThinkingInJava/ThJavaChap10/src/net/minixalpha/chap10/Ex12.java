package net.minixalpha.chap10;

abstract class Ex12Base {
	abstract void bar();
}

class Ex12Foo {
	private int i = 0;

	private void foo() {
		System.out.println("Ex12Foo.foo");
	}

	public int getI() {
		return i;
	}

	public void bar() {
		Ex12Base ex12Base = new Ex12Base() {

			@Override
			void bar() {
				i = 1;
				foo();

			}
		};
		
		ex12Base.bar();
	}

}

public class Ex12 {

	public static void main(String[] args) {
		Ex12Foo ex12Foo = new Ex12Foo();
		System.out.println(ex12Foo.getI());
		ex12Foo.bar();
		System.out.println(ex12Foo.getI());
	}

}
