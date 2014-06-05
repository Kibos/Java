package net.minixalpha.chap15;

public class Ex10 {
	static public <A, B> void f(A a, B b, String c) {
		System.out.println(a.getClass().getSimpleName() + " "
				+ b.getClass().getSimpleName() + " " + c);
	}

	public static void main(String[] args) {
		f(0, 1.2, "3");
	}

}
