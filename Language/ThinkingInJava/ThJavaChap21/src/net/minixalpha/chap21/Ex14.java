package net.minixalpha.chap21;

import java.util.Timer;
import java.util.TimerTask;

class Ex14Task extends TimerTask {
	private static int seq;

	@Override
	public void run() {
		System.out.println(seq++);
	}

}

public class Ex14 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			new Timer().schedule(new Ex14Task(), i * 1000);
		}
	}
}
