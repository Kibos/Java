package net.minixalpha.chap21;

class A {
	public int a = 1;

	public int getA() {
		return this.a;
	}
}

class B extends A {
	public int a = 2;

}

public class TestExtends {
	public static void main(String[] args) {
		A b = new B();
		System.out.println(b.a);
	}
}
