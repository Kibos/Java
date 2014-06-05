package net.minixalpha.chap17;

import static net.mindview.util.Print.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class AssociativeArray<K, V> {
	private Object[][] pairs;
	private int index;

	public AssociativeArray(int length) {
		pairs = new Object[length][2];
	}

	public void put(K key, V value) {
		if (index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++] = new Object[] { key, value };
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		for (int i = 0; i < index; i++)
			if (key.equals(pairs[i][0]))
				return (V) pairs[i][1];
		return null; // Did not find key
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < index; i++) {
			result.append(pairs[i][0].toString());
			result.append(" : ");
			result.append(pairs[i][1].toString());
			if (i < index - 1)
				result.append("\n");
		}
		return result.toString();
	}

	static void testAssociativeArray() {
		AssociativeArray<String, String> map = new AssociativeArray<String, String>(
				6);
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		map.put("sun", "warm");
		try {
			map.put("extra", "object"); // Past the end
		} catch (ArrayIndexOutOfBoundsException e) {
			print("Too many objects!");
		}
		print(map);
		print(map.get("ocean"));
	}

	static void testMap(Map map) {
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		map.put("sun", "warm");
		try {
			map.put("extra", "object"); // Past the end
		} catch (ArrayIndexOutOfBoundsException e) {
			print("Too many objects!");
		}
		print(map);
		print(map.get("ocean"));
	}

	public static void main(String[] args) {
		testMap(new HashMap<String, String>());
		testMap(new TreeMap<>());
		testMap(new LinkedHashMap<>()); // by inserted order
	}
}

public class Ex12 {
	public static void main(String[] args) {
		AssociativeArray.main(null);
	}
}
