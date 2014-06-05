package net.minixalpha.chap16;

import java.util.Arrays;

class BerylliumSphere18 {
	public int x = 1;

	public BerylliumSphere18(int x) {
		this.x = x;
	}

	public String toString() {
		return "" + this.x;
	}
}

public class Ex18 {
	public static void main(String[] args) {
		BerylliumSphere18[] bs = { new BerylliumSphere18(1),
				new BerylliumSphere18(2) };
		BerylliumSphere18[] bs2 = new BerylliumSphere18[2];
		System.arraycopy(bs, 0, bs2, 0, 2);
		System.out.println(Arrays.deepToString(bs));
		System.out.println(Arrays.deepToString(bs2));

		bs[0].x = 2;

		System.out.println(Arrays.deepToString(bs));
		System.out.println(Arrays.deepToString(bs2));
	}
}
