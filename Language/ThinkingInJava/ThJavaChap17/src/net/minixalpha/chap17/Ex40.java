package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;

class Ex40Demo implements Comparable<Ex40Demo> {
	private static RandomGenerator.String genString = new RandomGenerator.String();
	public String aString = genString.next();
	public String bString = genString.next();

	public Ex40Demo() {
		// TODO Auto-generated constructor stub
	}

	public Ex40Demo(String a, String b) {
		aString = a;
		bString = b;
	}

	@Override
	public int compareTo(Ex40Demo o) {
		return aString.compareTo(o.aString);
	}

	@Override
	public String toString() {
		return "(" + aString + "," + bString + ")";
	}

}

public class Ex40 {
	static void fillEx40Demo(ArrayList<Ex40Demo> demos, int size) {
		for (int i = 0; i < size; i++) {
			demos.add(new Ex40Demo());
		}
	}

	static void fillEx40Demo(Ex40Demo[] demos, int size) {
		for (int i = 0; i < size; i++) {
			demos[i] = new Ex40Demo();
		}
	}

	static void testCase1() {
		ArrayList<Ex40Demo> aDemos = new ArrayList<>();
		fillEx40Demo(aDemos, 10);
		System.out.println(aDemos);
		Collections.sort(aDemos);
		System.out.println(aDemos);
		System.out.println(Collections.binarySearch(aDemos, new Ex40Demo(
				"YNzbrny", "GcFOWZn")));
	}

	static void testCase2() {
		int size = 10;
		Ex40Demo[] aDemos = new Ex40Demo[size];
		fillEx40Demo(aDemos, size);
		System.out.println(Arrays.toString(aDemos));
		Arrays.sort(aDemos);
		System.out.println(Arrays.toString(aDemos));
		System.out.println(Arrays.binarySearch(aDemos, new Ex40Demo("qjncLdZ",
				"kpTkWng")));
	}

	public static void main(String[] args) {
		testCase1();
		testCase2();
	}
}
