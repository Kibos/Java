package net.minixalpha.chap16;

import java.util.Arrays;

import net.mindview.util.CountingGenerator;

public class Ex12 {
	public static void main(String[] args) {
		CountingGenerator.Double d = new CountingGenerator.Double();
		Double[] ds = new Double[3];
		for (int i=0; i<3; i++) {
			ds[i] = d.next();
		}
		System.out.println(Arrays.toString(ds));
	}
}
