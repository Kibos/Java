package net.minixalpha.chap21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Ex6Demo implements Runnable {
	Random rand = new Random();

	@Override
	public void run() {
		int time = rand.nextInt(10) + 1;
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(time);
		}
	}

}

public class Ex6 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(new Ex6Demo());
		}
		service.shutdown();
	}
}
