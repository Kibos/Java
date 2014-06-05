package net.minixalpha.chap10;

interface Ex13Inter {
	void foo();
}

public class Ex13 {

	public static void bar() {
		Ex13Inter ex13Inter = new Ex13Inter() {
			@Override
			public void foo() {
				System.out.println("I'm foo");
			}
		};

		ex13Inter.foo();
	}

	public static void main(String[] args) {
		bar();
	}

}
