package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;

class SimpleHashMap2<K, V> extends AbstractMap<K, V> {
	// Choose a prime number for the hash table
	// size, to achieve a uniform distribution:
	static final int SIZE = 997;
	static final float LOAD_FACTOR = 0.75f;
	// You can't have a physical array of generics,
	// but you can upcast to one:
	@SuppressWarnings("unchecked")
	ArrayList<MapEntry<K, V>>[] buckets = new ArrayList[SIZE];
	private int capacity = SIZE;
	private int size = 0;

	private void rehash() {
		int oldCapacity = capacity;
		capacity = oldCapacity + (oldCapacity >> 1);
		buckets = Arrays.copyOf(buckets, capacity);
	}

	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			buckets[index] = new ArrayList<MapEntry<K, V>>();
		ArrayList<MapEntry<K, V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		boolean found = false;
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		while (it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair); // Replace old with new
				found = true;
				break;
			}
		}
		if (!found)
			buckets[index].add(pair);

		size++;
		if (1.0 * size / capacity > LOAD_FACTOR) {
			rehash();
		}
		return oldValue;
	}

	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			return null;
		for (MapEntry<K, V> iPair : buckets[index])
			if (iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (ArrayList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null)
				continue;
			for (MapEntry<K, V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}

	public static void main(String[] args) {
		SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
		m.putAll(Countries.capitals(25));
		System.out.println(m);
		System.out.println(m.get("ERITREA"));
		System.out.println(m.entrySet());
	}
}

public class Ex39 {
	static List<Test<Map<Integer, Integer>>> tests = new ArrayList<Test<Map<Integer, Integer>>>();
	static {
		tests.add(new Test<Map<Integer, Integer>>("put") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					map.clear();
					for (int j = 0; j < size; j++)
						map.put(j, j);
				}
				return loops * size;
			}
		});
		tests.add(new Test<Map<Integer, Integer>>("get") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for (int i = 0; i < loops; i++)
					for (int j = 0; j < span; j++)
						map.get(j);
				return loops * span;
			}
		});
		tests.add(new Test<Map<Integer, Integer>>("iterate") {
			int test(Map<Integer, Integer> map, TestParam tp) {
				int loops = tp.loops * 10;
				for (int i = 0; i < loops; i++) {
					Iterator it = map.entrySet().iterator();
					while (it.hasNext())
						it.next();
				}
				return loops * map.size();
			}
		});
	}

	public static void main(String[] args) {
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		Tester.run(new HashMap<Integer, Integer>(), tests);
		Tester.run(new SimpleHashMap2<Integer, Integer>(), tests);
	}
}

/*
 *
 ---------- HashMap ----------
 size     put     get iterate
   10     394     146      44
  100      38      16       5
 1000      42      21       4
10000      45      15       5
------- SimpleHashMap2 -------
 size     put     get iterate
   10    8960     162   16713
  100   10313      13   20172
 1000   14680      23
 */
