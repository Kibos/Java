package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;
import java.util.Arrays;
import java.util.Collections;

class Ex42Demo implements Comparable<Ex42Demo> {
	private static RandomGenerator.String genString = new RandomGenerator.String();
	public String aString = genString.next();
	public String bString = genString.next();

	public Ex42Demo() {
		// TODO Auto-generated constructor stub
	}

	public Ex42Demo(String a, String b) {
		aString = a;
		bString = b;
	}

	@Override
	public int compareTo(Ex42Demo o) {
		int len1 = aString.length();
		int len2 = o.aString.length();
		int len = (len1 <= len2) ? len1 : len2;

		for (int i = 0; i < len; i++) {
			char c1 = Character.toLowerCase(aString.charAt(i));
			char c2 = Character.toLowerCase(o.aString.charAt(i));
			if (c1 != c2) {
				return c1 - c2;
			}
		}

		if (len1 > len) {
			return 1;
		}

		if (len2 > len) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "(" + aString + "," + bString + ")";
	}

}

public class Ex42 {
	static void fillEx42Demo(ArrayList<Ex42Demo> demos, int size) {
		for (int i = 0; i < size; i++) {
			demos.add(new Ex42Demo());
		}
	}

	static void fillEx42Demo(Ex42Demo[] demos, int size) {
		for (int i = 0; i < size; i++) {
			demos[i] = new Ex42Demo();
		}
	}

	static void testCase1() {
		ArrayList<Ex42Demo> aDemos = new ArrayList<>();
		fillEx42Demo(aDemos, 10);
		System.out.println(aDemos);
		Collections.sort(aDemos);
		System.out.println(aDemos);
		System.out.println(Collections.binarySearch(aDemos, new Ex42Demo(
				"YNzbrny", "GcFOWZn")));
	}

	static void testCase2() {
		int size = 10;
		Ex42Demo[] aDemos = new Ex42Demo[size];
		fillEx42Demo(aDemos, size);
		System.out.println(Arrays.toString(aDemos));
		Arrays.sort(aDemos);
		System.out.println(Arrays.toString(aDemos));
		System.out.println(Arrays.binarySearch(aDemos, new Ex42Demo("qjncLdZ",
				"kpTkWng")));
	}

	public static void main(String[] args) {
		testCase1();
		testCase2();
	}
}
