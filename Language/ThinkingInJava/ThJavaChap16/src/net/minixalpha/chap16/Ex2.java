package net.minixalpha.chap16;

class Ex2Demo {
}

public class Ex2 {
	public static Ex2Demo[] getDemos(int n) {
		Ex2Demo[] demos = new Ex2Demo[n];

		for (int i = 0; i < n; i++) {
			demos[i] = new Ex2Demo();
		}

		return demos;
	}

	public static void main(String[] args) {
		Ex2Demo[] demos = getDemos(2);
		System.out.println(demos[0]);
		System.out.println(demos[1]);
	}
}
