package net.minixalpha.chap15;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Ex17 {

	static <T> Set<T> getNewSet(Set<T> a) {
		if (a instanceof EnumSet<?>) {
			return ((EnumSet) a).clone();
		} else {
			return new HashSet<T>(a);
		}

	}

	class Sets {
		public <T> Set<T> union(Set<T> a, Set<T> b) {
			Set<T> result = getNewSet(a);
			result.addAll(b);
			return result;
		}

		public <T> Set<T> intersection(Set<T> a, Set<T> b) {
			Set<T> result = getNewSet(a);
			result.retainAll(b);
			return result;
		}

		// Subtract subset from superset:
		public <T> Set<T> difference(Set<T> superset, Set<T> subset) {
			Set<T> result = getNewSet(superset);
			result.removeAll(subset);
			return result;
		}

		// Reflexive--everything not in the intersection:
		public <T> Set<T> complement(Set<T> a, Set<T> b) {
			return difference(union(a, b), intersection(a, b));
		}
	}

	public static void main(String[] args) {

	}

}
