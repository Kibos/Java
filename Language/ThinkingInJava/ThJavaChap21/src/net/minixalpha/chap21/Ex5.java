package net.minixalpha.chap21;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Ex5Demo implements Callable<List> {
	private Fibonacci fibonacci = null;
	private int size;

	public Ex5Demo(int size) {
		this.fibonacci = new Fibonacci(size);
		this.size = size;
	}

	private Integer next() {
		return fibonacci.next();
	}

	@Override
	public List call() throws Exception {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(next());
		}
		return list;
	}

}

public class Ex5 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<List>> results = new ArrayList<Future<List>>();
		for (int i = 0; i < 10; i++) {
			results.add(service.submit(new Ex5Demo(10)));
		}

		for (Future<List> fs : results) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				service.shutdown();
			}
		}
	}
}
