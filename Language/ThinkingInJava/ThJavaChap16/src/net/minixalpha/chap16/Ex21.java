
package net.minixalpha.chap16;

import java.util.Arrays;
import java.util.Collections;


class BerylliumSphere21 implements Comparable<BerylliumSphere21>{
	public int x = 1;

	public BerylliumSphere21(int x) {
		this.x = x;
	}

	public String toString() {
		return "" + this.x;
	}

	@Override
	public int compareTo(BerylliumSphere21 o) {
		return this.x - o.x;
	}
}


public class Ex21 {
	public static void main(String[] args) {
		BerylliumSphere21[] a = {new BerylliumSphere21(3), new BerylliumSphere21(1), new BerylliumSphere21(4)};
		Arrays.sort(a);
		System.out.println(Arrays.deepToString(a));
		Arrays.sort(a, Collections.reverseOrder());
		System.out.println(Arrays.deepToString(a));
	}
}
