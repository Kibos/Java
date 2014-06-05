package net.minixalpha.chap16;

import java.util.*;

class Ex25Demo extends ArrayList<Integer> {

	public Ex25Demo(List<Integer> list) {
		this.addAll(list);
	}

	public ArrayList<Integer> getReversed() {
		ArrayList<Integer> reverseList = new ArrayList<>(this);
		Collections.reverse(reverseList);
		return reverseList;
	}
}

public class Ex25 {

	static void testCase1() {
		List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4,
				5));
		System.out.println(aList.getClass());
		System.out.println(aList);
		System.out.println(aList.get(4));
		aList.add(6);
		aList.addAll(Arrays.asList(7, 8));
		System.out.println(aList);
		List<Integer> subList = aList.subList(2, 4);
		System.out.println(subList);
	}

	static void testCase2() {
		List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4,
				5));
		Ex25Demo bList = new Ex25Demo(aList);

		System.out.println(aList);
		System.out.println(bList);
		System.out.println(bList.getReversed());
	}

	public static void main(String[] args) {
		testCase2();
	}
}
