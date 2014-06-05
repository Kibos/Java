package net.minixalpha.chap17;

import net.mindview.util.ThreeTuple;

public class Ex28 {
	// See *Tuple.java in net.mindview.util
	static ThreeTuple<Integer, Integer, Integer> make3tuple(int a, int b, int c) {
		return new ThreeTuple<Integer, Integer, Integer>(a, b, c);
	}

	static void testCompareTo() {
		ThreeTuple<Integer, Integer, Integer> a = make3tuple(1, 2, 3);

		System.out.println(a.compareTo(make3tuple(1, 2, 3)));
		System.out.println(a.compareTo(make3tuple(2, 2, 3)));
		System.out.println(a.compareTo(make3tuple(-1, 2, 3)));
		System.out.println(a.compareTo(make3tuple(1, -1, 3)));
		System.out.println(a.compareTo(make3tuple(1, 3, 3)));
		System.out.println(a.compareTo(make3tuple(1, 2, 2)));
		System.out.println(a.compareTo(make3tuple(1, 2, 4)));
	}

	static void testHashCode() {
		ThreeTuple<Integer, Integer, Integer> a = make3tuple(1, 2, 3);
		ThreeTuple<Integer, Integer, Integer> b = make3tuple(1, 2, 3);
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}

	static void testEquals() {
		ThreeTuple<Integer, Integer, Integer> a = make3tuple(1, 2, 3);
		ThreeTuple<Integer, Integer, Integer> b = make3tuple(1, 2, 3);
		ThreeTuple<Integer, Integer, Integer> c = make3tuple(2, 2, 3);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
	}

	public static void main(String[] args) {
		testHashCode();
		testEquals();
	}
}
