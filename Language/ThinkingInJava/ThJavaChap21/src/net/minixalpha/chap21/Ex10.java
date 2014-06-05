package net.minixalpha.chap21;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex10 {
	public static ExecutorService service = Executors.newCachedThreadPool();
	private static int count;

	public static Future<Integer> runTask(int n) {
		count = n;
		Callable<Integer> call = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				int a = 1, b = 1;
				for (int i = 0; i < count; i++) {
					sum += a;
					int c = a + b;
					a = b;
					b = c;
				}
				return sum;
			}
		};

		return service.submit(call);
	}

	public static void main(String[] args) {
		Future<Integer> fc = runTask(5);
		try {
			System.out.println(fc.get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}
}
