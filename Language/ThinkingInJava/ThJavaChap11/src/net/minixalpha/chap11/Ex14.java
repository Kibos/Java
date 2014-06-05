package net.minixalpha.chap11;

import java.util.LinkedList;
import java.util.ListIterator;

public class Ex14 {

	public static void main(String[] args) {
		LinkedList<Integer> ints = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			ListIterator<Integer> intsIterator = ints
					.listIterator(ints.size() / 2);
			intsIterator.add(i);
			System.out.println(ints);
		}
	}
}
