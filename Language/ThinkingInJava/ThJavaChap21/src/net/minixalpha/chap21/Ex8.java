package net.minixalpha.chap21;

import java.util.concurrent.TimeUnit;

public class Ex8 {
	// Dosen't all the threads of SimpleThread.java be daemon thread?
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {

			Thread x = new Thread(new LiftOff());
			x.setDaemon(true);
			x.start();
		}
		System.out.println("Waiting for LiftOff");
	}
}
