package net.minixalpha.chap15;

import java.util.Iterator;

interface Generator<T> {
	T next();
}

class Fibonacci implements Generator<Integer> {
	private int count = 0;

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0; i < 18; i++)
			System.out.print(gen.next() + " ");
	}
}

class IterableFibonacci implements Iterable<Integer> {

	private int n;
	private Fibonacci gen = new Fibonacci();

	public IterableFibonacci(int count) {
		this.n = count;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				n--;
				return gen.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}

public class Ex7 {
	public static void main(String[] args) {
		for(int i: new IterableFibonacci(10)) {
			System.out.println(i);
		}
	}
}
