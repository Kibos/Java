//: net/mindview/util/ThreeTuple.java
package net.mindview.util;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
	public final C third;

	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		third = c;
	}

	public boolean equals(Object o) {
		if (o instanceof ThreeTuple) {
			ThreeTuple<A, B, C> to = (ThreeTuple) o;
			return super.equals(o) && to.third.equals(third);
		}
		return false;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 37 + third.hashCode();

		return hash;
	}

	public int compareTo(ThreeTuple<A, B, C> o) {
		int superCmp = super.compareTo(o);

		if (superCmp != 0) {
			return superCmp;
		} else if (third.equals(o.third) == false) {
			Comparable<C> cmp = (Comparable<C>) third;
			return cmp.compareTo(o.third);
		} else {
			return 0;
		}
	}

	public String toString() {
		return "(" + first + ", " + second + ", " + third + ")";
	}
} // /:~
