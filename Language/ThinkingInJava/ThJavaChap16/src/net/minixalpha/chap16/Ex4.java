package net.minixalpha.chap16;

import java.util.Arrays;
import java.util.Random;

public class Ex4 {
	private static Double[][][] get3DDouble(int m, int n, int x, double s,
			double t) {
		Random rand = new Random();
		Double[][][] nums = new Double[m][n][x];
		double d = Math.abs(t - s);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < x; k++) {
					nums[i][j][k] = rand.nextDouble() * d + s;
				}
			}
		}
		return nums;
	}

	private static void display(Double[][][] nums) {
		System.out.println(Arrays.deepToString(nums));
	}

	public static void main(String[] args) {
		display(get3DDouble(3, 4, 5, 4.4, 5.3));

	}
}
