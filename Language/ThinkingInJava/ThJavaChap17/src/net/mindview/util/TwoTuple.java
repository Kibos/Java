//: net/mindview/util/TwoTuple.java
package net.mindview.util;

import java.lang.reflect.Field;

public class TwoTuple<A, B> implements Comparable<TwoTuple<A, B>> {
	public final A first;
	public final B second;

	public TwoTuple(A a, B b) {
		first = a;
		second = b;
	}

	public String toString() {
		return "(" + first + ", " + second + ")";
	}

	public boolean equals(Object o) {
		if (o instanceof TwoTuple) {
			TwoTuple<A, B> to = (TwoTuple) o;
			return first.equals(to.first) && second.equals(to.second);
		}
		return false;
	}

	public int hashCode() {
		int hash = 0;
		hash = 37 * hash + first.hashCode();
		hash = 37 * hash + second.hashCode();

		return hash;
	}

	@Override
	public int compareTo(TwoTuple<A, B> o) {
		if (o == null) {
			return 1;
		}

		if (first.equals(o.first) == false) {
			Comparable<A> cmp = (Comparable<A>) first;
			return cmp.compareTo(o.first);
		}

		if (second.equals(o.second) == false) {
			Comparable<B> cmp = (Comparable<B>) second;
			return cmp.compareTo(o.second);
		}

		return 0;
	}
} // /:~
