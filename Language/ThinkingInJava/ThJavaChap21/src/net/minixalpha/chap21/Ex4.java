package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex4 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(new Fibonacci(10));
		}
		service.shutdown(); // If ignore it, program will run forever
	}
}
