package net.minixalpha.chap21;

public class Ex2 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Fibonacci(10)).start();
		}
	}
}
