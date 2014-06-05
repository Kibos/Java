package net.minixalpha.chap15;

class Holder<T> {
	private T a;
	private T b;
	private T c;
	
	public Holder() {
	}

	public Holder(T a, T b, T c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public T getA() {
		return a;
	}

	public T getB() {
		return b;
	}

	public T getC() {
		return c;
	}
}

public class Ex2 {
	public static void main(String[] args) {
		Integer a = 1, b = 2, c = 3;
		Holder<Integer> holer = new Holder<Integer>(a, b, c);
		System.out.println(holer.getA());
		System.out.println(holer.getB());
		System.out.println(holer.getC());
	}
}
