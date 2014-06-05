package net.minixalpha.chap17;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

class SimpleHashSet<E> implements Set<E> {
	static final int SIZE = 997;
	private LinkedList<E>[] buckets = new LinkedList[SIZE];
	private int size = 0;

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int bucketsIndex = 0;
			Iterator<E> curIterator = null;

			@Override
			public boolean hasNext() {
				if (curIterator == null || curIterator.hasNext() == false) {
					while (bucketsIndex < SIZE && buckets[bucketsIndex] == null) {
						bucketsIndex++;
					}
					if (bucketsIndex < SIZE) {
						curIterator = buckets[bucketsIndex].iterator();
					}
				}
				return curIterator != null && curIterator.hasNext();
			}

			@Override
			public E next() {
				if (curIterator == null) {
					return null;
				} else {
					return curIterator.next();
				}
			}

			@Override
			public void remove() {
				if (bucketsIndex < SIZE && curIterator != null) {
					curIterator.remove();
				}
			}
		};
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
	public boolean contains(Object e) {
		int index = Math.abs(e.hashCode()) % SIZE;
		if (buckets[index] != null) {
			return buckets[index].contains(e);
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] objects = new Object[size];
		int j = 0;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				for (E ex : buckets[i]) {
					objects[j++] = ex;
				}
			}
		}

		return objects;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
		int index = Math.abs(e.hashCode()) % SIZE;
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<>();
		}
		LinkedList<E> list = buckets[index];
		for (E ex : list) {
			if (ex.equals(e)) {
				return false;
			}
		}
		size++;
		return list.add(e);
	}

	@Override
	public boolean remove(Object e) {
		int index = Math.abs(e.hashCode()) % SIZE;
		if (buckets[index] != null) {
			LinkedList<E> list = buckets[index];
			boolean result = list.remove(e);
			if (result) {
				size--;
			}
			return result;
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
	}

}

public class Ex24 {

}
