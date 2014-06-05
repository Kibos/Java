package net.minixalpha.chap16;

import java.util.Arrays;

import net.mindview.util.CountingGenerator;

public class Ex14 {
	private static CountingGenerator.Integer cGen = new CountingGenerator.Integer();
	private static CountingGenerator.Double dGen = new CountingGenerator.Double();

	public static int[] intGen(int size) {
		int[] intArray = new int[size];
		for (int i = 0; i < size; i++) {
			intArray[i] = cGen.next();
		}
		return intArray;
	}
	
	public static double[] doubleGen(int size) {
		double[] doubleArray = new double[size];
		for(int i = 0; i < size; i++) {
			doubleArray[i] = dGen.next();
		}
		return doubleArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intGen(5)));
		System.out.println(Arrays.toString(doubleGen(3)));
	}

}
