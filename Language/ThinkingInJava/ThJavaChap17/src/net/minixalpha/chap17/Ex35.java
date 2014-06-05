package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;

class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public V setValue(V v) {
		V result = value;
		value = v;
		return result;
	}

	public int hashCode() {
		return (key == null ? 0 : key.hashCode())
				^ (value == null ? 0 : value.hashCode());
	}

	public boolean equals(Object o) {
		if (!(o instanceof MapEntry))
			return false;
		MapEntry me = (MapEntry) o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey()))
				&& (value == null ? me.getValue() == null : value.equals(me
						.getValue()));
	}

	public String toString() {
		return key + "=" + value;
	}
}

class SlowMap35<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

	public V put(K key, V value) {
		V oldValue = get(key); // The old value or null
		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return oldValue;
	}

	public V get(Object key) { // key is type Object, not K
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while (ki.hasNext())
			set.add(new MapEntry<K, V>(ki.next(), vi.next()));
		return set;
	}

	public static void main(String[] args) {
		SlowMap35<String, String> m = new SlowMap35<String, String>();
		m.putAll(Countries.capitals(15));
		System.out.println(m);
		System.out.println(m.get("BULGARIA"));
		System.out.println(m.entrySet());
	}
}


class MapPerformance {
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
		Tester.run(new TreeMap<Integer, Integer>(), tests);
		Tester.run(new HashMap<Integer, Integer>(), tests);
		Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
		Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
		Tester.run(new WeakHashMap<Integer, Integer>(), tests);
		Tester.run(new Hashtable<Integer, Integer>(), tests);
		Tester.run(new SlowMap35<Integer, Integer>() , tests);
	}
}

public class Ex35 {
	public static void main(String[] args) {
/*
 *
 ---------- SlowMap35 ----------
 size     put     get iterate
   10     910      30     162
  100     919     167     545
 1000    8129    1507    4772
10000   88026   18147
 */
	}
}
