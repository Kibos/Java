package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;

class MapEntry19<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry19(K key, V value) {
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
		if (!(o instanceof MapEntry19))
			return false;
		MapEntry19 me = (MapEntry19) o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey()))
				&& (value == null ? me.getValue() == null : value.equals(me
						.getValue()));
	}

	public String toString() {
		return key + "=" + value;
	}
}

class SimpleHashMap19<K, V> implements Map<K, V> {
	// Choose a prime number for the hash table
	// size, to achieve a uniform distribution:
	static final int SIZE = 997;
	// You can't have a physical array of generics,
	// but you can upcast to one:
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry19<K, V>>[] buckets = new LinkedList[SIZE];
	LinkedList<K> keys = new LinkedList<>();
	LinkedList<V> values = new LinkedList<>();
	private int size = 0;

	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
		size = 0;
		keys.clear();
		values.clear();
	}

	public V remove(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			return null;
		for (MapEntry19<K, V> iPair : buckets[index])
			if (iPair.getKey().equals(key)) {
				V value = iPair.getValue();
				buckets[index].remove(iPair);
				keys.remove(key);
				size--;
				return value;
			}
		return null;
	}

	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<MapEntry19<K, V>>();
		} else {
			System.err.println("Key " + key + " Conflict at " + index);
		}
		LinkedList<MapEntry19<K, V>> bucket = buckets[index];
		MapEntry19<K, V> pair = new MapEntry19<K, V>(key, value);
		boolean found = false;
		ListIterator<MapEntry19<K, V>> it = bucket.listIterator();

		int tryCount = 0;
		while (it.hasNext()) {
			MapEntry19<K, V> iPair = it.next();
			tryCount++;
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair); // Replace old with new
				found = true;
				System.err.println("Try " + tryCount
						+ " times to find conflict");
				break;
			}
		}
		if (!found)
			buckets[index].add(pair);
		size++;
		keys.add(key);
		values.add(value);
		return oldValue;
	}

	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			return null;
		for (MapEntry19<K, V> iPair : buckets[index])
			if (iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (LinkedList<MapEntry19<K, V>> bucket : buckets) {
			if (bucket == null)
				continue;
			for (MapEntry19<K, V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				for (MapEntry19<K, V> iPair : buckets[i]) {
					if (iPair.getValue().equals(value))
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (java.util.Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public Set<K> keySet() {
		return new AbstractSet<K>() {
			@Override
			public Iterator<K> iterator() {
				return keys.iterator();
			}

			@Override
			public int size() {
				return keys.size();
			}
		};
	}

	@Override
	public Collection<V> values() {
		return values;
	}

}

public class Ex19 {
	static SimpleHashMap19<String, Integer> testMap(String[] words) {
		SimpleHashMap19<String, Integer> map = new SimpleHashMap19<>();
		for (String wd : words) {
			Integer value = map.get(wd);
			if (value == null) {
				value = 0;
			}
			map.put(wd, value + 1);
		}
		return map;
	}

	public static void main(String[] args) {
		String content = TextFile.read("news.txt");
		String[] words = content.split("[, ]");
		SimpleHashMap19<String, Integer> map = testMap(words);
		System.out.println(map);
	}
}
