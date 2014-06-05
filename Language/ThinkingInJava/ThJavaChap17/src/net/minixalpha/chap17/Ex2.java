package net.minixalpha.chap17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.mindview.util.Countries;

public class Ex2 {
	static void testMap() {
		Map<String, String> map = new HashMap<>(Countries.capitals());
		Map<String, String> Amap = new HashMap<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.startsWith("A")) {
				Amap.put(key, entry.getValue());
			}
		}

		System.out.println(Amap);
	}

	static void testSet() {
		Set<Entry<String, String>> set = Countries.capitals().entrySet();
		Set<String> Aset = new HashSet<>();
		for (Entry<String, String> entry : Countries.capitals().entrySet()) {
			String key = entry.getKey();
			if (key.startsWith("A")) {
				Aset.add(key);
			}
		}
		System.out.println(Aset);

	}

	public static void main(String[] args) {
		testMap();
		testSet();
	}
}
