package net.minixalpha.chap21;

import java.util.concurrent.*;

class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		exec.shutdownNow();
		exec.shutdown();
	}
}

public class Ex20 {
	public static void main(String[] args) {
		CachedThreadPool.main(args);
	}
}
