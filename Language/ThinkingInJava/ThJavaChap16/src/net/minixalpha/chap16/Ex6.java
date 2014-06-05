package net.minixalpha.chap16;

class Ex6Demo {
}

public class Ex6 {
	public static Ex6Demo[][] get2DDemos(int m, int n) {
		Ex6Demo[][] demos = new Ex6Demo[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				demos[i][j] = new Ex6Demo();
			}
		}
		return demos;
	}

	public static void main(String[] args) {
		Ex6Demo[][] demos = get2DDemos(2, 3);
	}
}
