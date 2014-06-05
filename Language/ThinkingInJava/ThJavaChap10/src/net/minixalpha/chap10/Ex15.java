package net.minixalpha.chap10;

class Ex15Foo {
	public Ex15Foo(int i) {
		System.out.println(i);
	}
}

public class Ex15 {

	Ex15Foo getFoo() {
		return new Ex15Foo(0) {
		};
	}

	public static void main(String[] args) {
		Ex15 ex15 = new Ex15();
		Ex15Foo ex15Foo = ex15.getFoo();
	}

}
