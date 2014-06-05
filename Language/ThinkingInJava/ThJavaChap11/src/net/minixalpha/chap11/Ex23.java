package net.minixalpha.chap11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Ex23 {

	static int testRandom(int seed) {
		Random rand = new Random(47);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10000; i++) {
			// Produce a number between 0 and 20:
			int r = rand.nextInt(seed);
			Integer freq = m.get(r);
			m.put(r, freq == null ? 1 : freq + 1);
			set.add(r);
		}
		
		int maxKey = -1;
		int maxValue = 0;
		int value;
		for (Integer key: set) {
			value = m.get(key);
			if (value > maxValue) {
				maxValue = value;
				maxKey = key;
			}
		}
		
		return maxKey;
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextInt());
	}

}
