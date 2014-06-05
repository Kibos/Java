package net.minixalpha.chap16;

import java.util.Arrays;

public class Ex20 {
	public static void main(String[] args) {
		int a[][] = { { 1 }, { 2, 3 } };
		int b[][] = { { 1 }, { 2, 3 } };
		int c[][] = { { 2 }, { 2, 3 } };
		System.out.println(Arrays.deepEquals(a, b));
		System.out.println(Arrays.deepEquals(a, c));
	}
}