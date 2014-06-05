package net.minixalpha.chap17;

//: net/mindview/util/CountingMapData.java
//Unlimited-length Map containing sample data.

import java.util.*;
import java.util.Map.Entry;

class CountingMapData2 extends AbstractMap<Integer, String> {
	private int size;
	private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
			.split(" ");

	public CountingMapData2(int size) {
		if (size < 0)
			this.size = 0;
		this.size = size;
	}

	private static class Entry implements Map.Entry<Integer, String> {
		int index;

		Entry(int index) {
			this.index = index;
		}

		public boolean equals(Object o) {
			return Integer.valueOf(index).equals(o);
		}

		public Integer getKey() {
			return index;
		}

		public String getValue() {
			return chars[index % chars.length]
					+ Integer.toString(index / chars.length);
		}

		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}

		public int hashCode() {
			return Integer.valueOf(index).hashCode();
		}
	}

	static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
		private int size;

		private static Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<Map.Entry<Integer, String>>();

		public EntrySet(int size) {
			this.size = size;
			for (int i = 0; i < size; i++)
				entries.add(new Entry(i));
		}

		@Override
		public Iterator<java.util.Map.Entry<Integer, String>> iterator() {
			return new Iterator<Map.Entry<Integer, String>>() {
				private int index = 0;

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

				@Override
				public boolean hasNext() {
					return index < size;
				}

				@Override
				public java.util.Map.Entry<Integer, String> next() {
					return (java.util.Map.Entry<Integer, String>) entries
							.toArray()[index++];
				}
			};
		}

		@Override
		public int size() {
			return size;
		}

	}

	public Set<Map.Entry<Integer, String>> entrySet() {
		// LinkedHashSet retains initialization order:
		return new EntrySet(20);
	}

	public static void main(String[] args) {
		// System.out.println(new CountingMapData2(60));
		Set<java.util.Map.Entry<Integer, String>> set = new CountingMapData2(60)
				.entrySet();

		for (java.util.Map.Entry<Integer, String> entry : set) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
} /*
 * Output: {0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0, 10=K0,
 * 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0, 18=S0, 19=T0, 20=U0, 21=V0,
 * 22=W0, 23=X0, 24=Y0, 25=Z0, 26=A1, 27=B1, 28=C1, 29=D1, 30=E1, 31=F1, 32=G1,
 * 33=H1, 34=I1, 35=J1, 36=K1, 37=L1, 38=M1, 39=N1, 40=O1, 41=P1, 42=Q1, 43=R1,
 * 44=S1, 45=T1, 46=U1, 47=V1, 48=W1, 49=X1, 50=Y1, 51=Z1, 52=A2, 53=B2, 54=C2,
 * 55=D2, 56=E2, 57=F2, 58=G2, 59=H2}
 */// :~

public class Ex5 {
	public static void main(String[] args) {

	}
}