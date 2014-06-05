package net.minixalpha.chap17;

import java.util.*;

import net.mindview.util.*;

class MapEntry15<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry15(K key, V value) {
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
		if (!(o instanceof MapEntry15))
			return false;
		MapEntry15 me = (MapEntry15) o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey()))
				&& (value == null ? me.getValue() == null : value.equals(me
						.getValue()));
	}

	public String toString() {
		return key + "=" + value;
	}
}

class SlowMap<K, V> implements Map<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

	public Set<K> keySet() {
		return new WeakArrayList<K>(keys);
	}

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

	public V remove(Object key) {
		if (!keys.contains(key)) {
			return null;
		}
		int index = keys.indexOf(key);
		keys.remove(index);
		return values.remove(index);
	}

	public boolean isEmpty() {
		return keys.isEmpty();
	}

	public void clear() {
		keys.clear();
		values.clear();
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while (ki.hasNext())
			set.add(new MapEntry15<K, V>(ki.next(), vi.next()));
		return set;
	}

	public static void main(String[] args) {
		SlowMap<String, String> m = new SlowMap<String, String>();
		m.putAll(Countries.capitals(15));
		System.out.println(m);
		System.out.println(m.get("BULGARIA"));
		System.out.println(m.entrySet());
	}

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public boolean containsKey(Object key) {
		return keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return keys.contains(value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (java.util.Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			keys.add(entry.getKey());
			values.add(entry.getValue());
		}
	}

	@Override
	public Collection<V> values() {
		return values();
	}

	static class WeakArrayList<K> implements Set<K> {
		List<K> keysRef;

		public WeakArrayList(List<K> keys) {
			keysRef = keys;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			return keysRef.contains(o);
		}

		@Override
		public Iterator<K> iterator() {
			return keysRef.iterator();
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add(K e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends K> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			keysRef.removeAll(c);
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}

	}
}

public class Ex15 {
	static SlowMap<String, Integer> testMap(String[] words) {
		SlowMap<String, Integer> map = new SlowMap<>();
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
		SlowMap<String, Integer> map = testMap(words);
		System.out.println(map);
	}
}
