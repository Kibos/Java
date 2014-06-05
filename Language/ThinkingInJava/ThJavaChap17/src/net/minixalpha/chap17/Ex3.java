package net.minixalpha.chap17;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.TreeSelectionEvent;

import net.mindview.util.Countries;

public class Ex3 {

	static void testSet(Class<? extends Set> c) throws InstantiationException,
			IllegalAccessException {
		Map<String, String> caps2 = Countries.capitals(2);
		Set<String> countrySet = c.newInstance();

		for (int i = 0; i < 10; i++) {
			for (Map.Entry<String, String> cap : caps2.entrySet()) {
				countrySet.add(cap.getKey());
			}
		}

		for (String cap : countrySet) {
			System.out.println(cap);
		}
		System.out.println("---");

	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {
		testSet(HashSet.class);
		testSet(TreeSet.class);
		testSet(LinkedHashSet.class);

	}
}
