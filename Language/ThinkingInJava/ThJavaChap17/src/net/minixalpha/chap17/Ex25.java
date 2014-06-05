package net.minixalpha.chap17;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Countries;

class MapEntry25<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;
	public MapEntry25<K, V> next;

	public MapEntry25(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
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
		if (!(o instanceof MapEntry25))
			return false;
		MapEntry25 me = (MapEntry25) o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey()))
				&& (value == null ? me.getValue() == null : value.equals(me
						.getValue()));
	}

	public String toString() {
		return key + "=" + value;
	}
}

class SimpleHashMap25<K, V> implements Map<K, V> {
	// Choose a prime number for the hash table
	// size, to achieve a uniform distribution:
	static final int SIZE = 997;
	// You can't have a physical array of generics,
	// but you can upcast to one:
	@SuppressWarnings("unchecked")
	MapEntry25<K, V>[] buckets = new MapEntry25[SIZE];
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
		MapEntry25<K, V> iPair = buckets[index];
		MapEntry25<K, V> iPairPre = null;

		while (iPair != null) {
			if (iPair.getKey().equals(key)) {
				V value = iPair.getValue();

				if (iPairPre != null) {
					iPairPre.next = iPair.next;
				} else {
					buckets[index] = null;
				}

				keys.remove(key);

				size--;
				return value;
			}
			iPairPre = iPair;
			iPair = iPair.next;
		}
		return null;
	}

	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			buckets[index] = new MapEntry25<K, V>(key, value);
		} else {
			System.err.println("Key " + key + " Conflict at " + index);
		}
		MapEntry25<K, V> bucket = buckets[index];
		MapEntry25<K, V> pair = new MapEntry25<K, V>(key, value);
		boolean found = false;

		int tryCount = 0;
		MapEntry25<K, V> lastPair = null;
		while (bucket != null) {
			MapEntry25<K, V> iPair = bucket;
			tryCount++;
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				bucket.setValue(iPair.getValue()); // Replace old with new
				found = true;
				System.err.println("Try " + tryCount
						+ " times to find conflict");
				break;
			}
			lastPair = bucket;
			bucket = bucket.next;
		}
		if (!found) {
			lastPair.next = pair;
		}

		size++;
		keys.add(key);
		values.add(value);
		return oldValue;
	}

	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null)
			return null;
		MapEntry25<K, V> iPair = buckets[index];

		while (iPair != null) {
			if (iPair.getKey().equals(key))
				return iPair.getValue();
			iPair = iPair.next;
		}

		return null;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (MapEntry25<K, V> bucket : buckets) {
			if (bucket == null)
				continue;

			MapEntry25<K, V> iPair = bucket;

			while (iPair != null) {
				set.add(iPair);
				iPair = iPair.next;
			}
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
				MapEntry25<K, V> iPair = buckets[i];

				while (iPair != null) {
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

public class Ex25 {
	public static void main(String[] args) {
		SimpleHashMap25<String, String> m = new SimpleHashMap25<String, String>();
		m.putAll(Countries.capitals(25));
		System.out.println(m);
		System.out.println(m.get("ERITREA"));
		System.out.println(m.entrySet());
	}
}
