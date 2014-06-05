package net.minixalpha.chap17;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Generated;

import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

public class Ex9 {
	static void fill(Set<String> set, int size) {
		Generator<String> gen = new RandomGenerator.String();
		for (int i = 0; i < size; i++) {
			set.add(gen.next());
		}
	}

	static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			int o1Len = o1.length();
			int o2Len = o2.length();
			int len = (o1Len < o2Len) ? o1Len : o2Len;

			for (int i = 0; i < len; i++) {
				char c1 = Character.toLowerCase(o1.charAt(i));
				char c2 = Character.toLowerCase(o2.charAt(i));
				if (c1 < c2) {
					return -1;
				} else if (c1 > c2) {
					return 1;
				}
			}

			if (o1Len > len) {
				return 1;
			}

			if (o2Len > len) {
				return -1;
			}

			return 0;
		}
	}

	public static void main(String[] args) {
		Set<String> set = new TreeSet<>(new StringComparator());
		fill(set, 10);
		System.out.println(set);
	}

}
