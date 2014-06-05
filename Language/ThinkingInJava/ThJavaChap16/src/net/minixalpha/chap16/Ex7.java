package net.minixalpha.chap16;

class Ex7Demo {
}

public class Ex7 {
	public static Ex7Demo[][][] get2DDemos(int m, int n, int t) {
		Ex7Demo[][][] demos = new Ex7Demo[m][n][t];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < t; k++) {
					demos[i][j][k] = new Ex7Demo();
				}
			}
		}
		return demos;
	}

	public static void main(String[] args) {
		Ex7Demo[][][] demos = get2DDemos(2, 3, 4);
	}
}