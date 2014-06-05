package net.minixalpha.chap16;

import java.util.Arrays;

public class Ex22 {

	static void search(int[] a) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(Arrays.binarySearch(a, a[j]) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, -4, 634 };
		search(a);
		
		int[] b = {-4, 1, 2, 5, 634 };
		search(b);
	}
}
