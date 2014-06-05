package net.minixalpha.chap21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Ex3Demo implements Runnable {
	private int id = 0;
	private static int taskSeq = 0;

	public Ex3Demo() {
		System.out.println("start: " + taskSeq);
		taskSeq++;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("running ... " + taskSeq + ":" + id++);
			Thread.yield();
		}
	}

}

public class Ex3 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			service.execute(new Ex1Demo());
		}
		service.shutdown();
	}
}
