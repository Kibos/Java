package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Ex18Demo {
	public void play() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Ex18 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Future<?> result = service.submit(new Runnable() {
			Ex18Demo demo = new Ex18Demo();

			@Override
			public void run() {
				demo.play();
			}
		});
		result.cancel(true);
		service.shutdown();
	}
}
