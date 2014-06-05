package net.minixalpha.chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.mindview.util.*;

public class Ex1 {

	static void printPairList(List<String[]> list) {
		for (String[] pair : list) {
			System.out.print("(" + pair[0] + "," + pair[1] + "),");
		}
		System.out.println();
	}

	static void testList(List<String[]> list) {
		System.out.println(list.getClass());
		printPairList(list);
		Collections.shuffle(list);
		printPairList(list);
		Collections.shuffle(list);
		printPairList(list);
		System.out.println("---");
	}

	public static void main(String[] args) {
		List<String[]> list1 = new ArrayList<>(Arrays.asList(Countries.DATA));
		testList(list1);

		List<String[]> list2 = new LinkedList<>(Arrays.asList(Countries.DATA));
		testList(list2);
	}
}
