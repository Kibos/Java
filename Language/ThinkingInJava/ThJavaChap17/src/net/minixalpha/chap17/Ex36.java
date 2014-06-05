package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;


class SlowMap2<K, V> extends AbstractMap<K, V> {
	private List<MPair<K, V>> datas = new ArrayList<>();

	class MPair<K, V> implements Comparable {
		public K key;
		public V value;

		public MPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Object o) {
			MPair<K, V> mo = (MPair) o;
			Comparable<K> ck = (Comparable) key;
			int result = ck.compareTo(mo.key);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			return compareTo(obj) == 0;
		}
	}

	public V put(K key, V value) {
		datas.add(new MPair(key, value));
		Collections.sort(datas);
		return value;
	}

	public V get(Object key) { // key is type Object, not K
		Comparator<MPair<K, V>> comparator = new Comparator<MPair<K, V>>() {

			@Override
			public int compare(MPair<K, V> o1, MPair<K, V> o2) {
				Comparable<K> ck = (Comparable) o1.key;
				return ck.compareTo(o2.key);
			}
		};
		MPair<K, V> tPair = new MPair<K, V>((K) key, null);
		int target = Collections.binarySearch(datas, tPair, comparator);
		if (target < 0) {
			return null;
		} else {
			System.out.println(target);
		}
		return datas.get(target).value;
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (MPair pair : datas) {
			set.add(new MapEntry(pair.key, pair.value));
		}
		return set;
	}

	public static void main(String[] args) {
		SlowMap<String, String> m = new SlowMap<String, String>();
		m.putAll(Countries.capitals(15));
		System.out.println(m);
		System.out.println(m.get("BULGARIA"));
		System.out.println(m.entrySet());
	}
}

public class Ex36 {
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
		Tester.run(new SlowMap2<Integer, Integer>(), tests);
	}

}

/*
 * When not sort
 * 
 * ---------- SlowMap2 ---------- 
 * size put get iterate 
 * 10 278767 82453
 */

/*
 * After sort
 *  ---------- SlowMap2 ----------
 *   size put get iterate 
 *   10 415824 265
 */