package net.minixalpha.chap17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import net.mindview.util.Countries;

public class Ex7 {

	static void testIter(List<String> list) {
		Iterator<String> normalIterator = list.iterator();
		while (normalIterator.hasNext()) {
			System.out.print(normalIterator.next() + " ");
		}
		System.out.println();
	}

	static void testInsert(List<String> list1, List<String> list2) {
		ListIterator<String> list1Iterator = list1.listIterator();
		ListIterator<String> list2Iterator = list2.listIterator();

		while (list1Iterator.hasNext()) {
			list1Iterator.next();
		}

		while (list1Iterator.hasPrevious()) {
			if (list2Iterator.hasNext()) {
				String curItem = list2Iterator.next();
				list1Iterator.previous();
				list1Iterator.previous();
				if (list1Iterator.hasPrevious()) {
					list1Iterator.add(curItem);
				} else {
					break;
				}
			} else {
				break;
			}
		}

		while (list1Iterator.hasNext()) {
			System.out.println(list1Iterator.next());
		}
	}

	static void testCase1() {
		List<String> list1 = new ArrayList<>(Countries.names());
		List<String> list2 = new LinkedList<>(Countries.names());
		testIter(list1);
		testIter(list2);

		System.out.println();

		testInsert(list1, list2);

	}

	public static void main(String[] args) {
		testCase1();
	}
}
