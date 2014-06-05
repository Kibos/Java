package net.minixalpha.chap21;

public class Fibonacci implements Generator<Integer>, Runnable {
	private int count = 0;
	protected int size;

	public Fibonacci(int size) {
		this.size = size;
	}

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	@Override
	public void run() {
		for (int i = 0; i < size; i++)
			System.out.print(next() + " ");
		System.out.println();
	}
}