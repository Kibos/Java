package net.minixalpha.chap17;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex6 {

	static void testUnSupport(List<Integer> list) {
		list.set(1, 3);
		ListIterator<Integer> iter = list.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		testUnSupport(list);
	}
}
