package net.minixalpha.chap15;

public class Ex9 {
	static public <A, B, C> void f(A a, B b, C c) {
		System.out.println(a.getClass().getSimpleName() + " "
				+ b.getClass().getSimpleName() + " "
				+ c.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		f(0, 1.2, "3");
	}

}