package net.minixalpha.chap21;

class Ex1Demo implements Runnable {
	private int id = 0;
	private static int taskSeq = 0;
	public Ex1Demo() {
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

public class Ex1 {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(new Ex1Demo()).start();
		}
	}
}
