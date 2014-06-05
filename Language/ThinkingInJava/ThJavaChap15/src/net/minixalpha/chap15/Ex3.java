package net.minixalpha.chap15;

class SixTuple<A, B, C, D, E, F> {
	public final A a;
	public final B b;
	public final C c;
	public final D d;
	public final E e;
	public final F f;

	public SixTuple(A a, B b, C c, D d, E e, F f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
}

public class Ex3 {
	public static void main(String[] args) {
		SixTuple<Integer, String, Character, Double, Float, Boolean> sTuple = 
				new SixTuple<Integer, String, Character, Double, Float, Boolean>(
				1, "2", '3', 4.0, 5.1f, false);
		System.out.println(sTuple.a);
		System.out.println(sTuple.b);
	}
}
