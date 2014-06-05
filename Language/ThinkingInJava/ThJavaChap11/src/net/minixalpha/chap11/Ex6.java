package net.minixalpha.chap11;

import typeinfo.pets.*;
import java.util.*;

public class Ex6 {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<String> pets = new ArrayList<String>();

		Random random = new Random();
		String[] strings = {"a", "b", "c", "d", "e", "f", "g"};
		for (int i = 0; i < 7; i++) {
			pets.add(strings[i]);
		}

		System.out.println("1: " + pets);
		// Hamster h = new Hamster();
		String h = new String("h");
		pets.add(h); // Automatically resizes
		System.out.println("2: " + pets);
		System.out.println("3: " + pets.contains(h));
		pets.remove(h); // Remove by object
		String p = pets.get(2);
		System.out.println("4: " + p + " " + pets.indexOf(p));
		Pet cymric = new Cymric();
		System.out.println("5: " + pets.indexOf(cymric));
		System.out.println("6: " + pets.remove(cymric));
		// Must be the exact object:
		System.out.println("7: " + pets.remove(p));
		System.out.println("8: " + pets);
		pets.add(3, new String("i")); // Insert at an index
		System.out.println("9: " + pets);
		List<String> sub = pets.subList(1, 4);
		System.out.println("subList: " + sub);
		System.out.println("10: " + pets.containsAll(sub));
		Collections.sort(sub); // In-place sort
		System.out.println("sorted subList: " + sub);
		// Order is not important in containsAll():
		System.out.println("11: " + pets.containsAll(sub));
		Collections.shuffle(sub, rand); // Mix it up
		System.out.println("shuffled subList: " + sub);
		System.out.println("12: " + pets.containsAll(sub));
		List<String> copy = new ArrayList<String>(pets);
		sub = Arrays.asList(pets.get(1), pets.get(4));
		System.out.println("sub: " + sub);
		copy.retainAll(sub);
		System.out.println("13: " + copy);
		copy = new ArrayList<String>(pets); // Get a fresh copy
		copy.remove(2); // Remove by index
		System.out.println("14: " + copy);
		copy.removeAll(sub); // Only removes exact objects
		System.out.println("15: " + copy);
		copy.set(1, new String("j")); // Replace an element
		System.out.println("16: " + copy);
		copy.addAll(2, sub); // Insert a list in the middle
		System.out.println("17: " + copy);
		System.out.println("18: " + pets.isEmpty());
		pets.clear(); // Remove all elements
		System.out.println("19: " + pets);
		System.out.println("20: " + pets.isEmpty());
		pets.addAll(Arrays.asList("k", "l", "m", "n"));
		System.out.println("21: " + pets);
		Object[] o = pets.toArray();
		System.out.println("22: " + o[3]);
	}
}
