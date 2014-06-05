package net.minixalpha.chap16;

import java.util.Arrays;
import java.util.Comparator;

class Ex24Demo2 {
	private int id;

	public Ex24Demo2(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Ex24Demo2) obj).getID();
	}

	public String toString() {
		return Integer.toString(id);
	}
}

class Ex24Demo2Comparator implements Comparator<Ex24Demo2> {

	static Ex24Demo2Comparator comparator = new Ex24Demo2Comparator();

	@Override
	public int compare(Ex24Demo2 o1, Ex24Demo2 o2) {
		return o1.getID() - o2.getID();
	}

	public static Ex24Demo2Comparator getComparator() {
		return comparator;
	}

}

public class Ex24 {
	public static void main(String[] args) {
		Ex24Demo2[] demos = { new Ex24Demo2(4), new Ex24Demo2(0),
				new Ex24Demo2(-1) };
		Arrays.sort(demos, Ex24Demo2Comparator.getComparator());
		System.out.println(Arrays.toString(demos));

		int index = Arrays.binarySearch(demos, new Ex24Demo2(0),
				Ex24Demo2Comparator.getComparator());
		System.out.println(index);

		int index2 = Arrays.binarySearch(demos, new Ex24Demo2(-9),
				Ex24Demo2Comparator.getComparator());
		System.out.println(index2);
	}
}
