package net.minixalpha.chap16;

import java.util.Arrays;
import java.util.Random;

public class Ex3 {
	private static Double[][] get2DDouble(int m, int n, double s, double t) {
		Random rand = new Random();
		Double[][] nums = new Double[m][n];
		double d = Math.abs(t - s);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j] = rand.nextDouble() * d + s;
			}
		}
		return nums;
	}
	
	private static void display(Double[][] nums) {
		System.out.println(Arrays.deepToString(nums));
	}
	
	public static void main(String[] args) {
		display(get2DDouble(2, 3, 4.3, 5.2));
	}
}
