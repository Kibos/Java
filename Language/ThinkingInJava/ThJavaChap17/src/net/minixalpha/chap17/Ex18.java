package net.minixalpha.chap17;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class SlowSet<E> extends AbstractSet<E> {
	private List<E> keys = new ArrayList<E>();

	@Override
	public Iterator<E> iterator() {
		return keys.iterator();
	}

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public boolean isEmpty() {
		return keys.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return keys.contains(o);
	}

	@Override
	public Object[] toArray() {
		return keys.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return keys.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return keys.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return keys.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return keys.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return keys.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return keys.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return keys.removeAll(c);
	}

	@Override
	public void clear() {
		keys.clear();
	}

}

public class Ex18 {

	public static void main(String[] args) {
		SlowSet<Integer> slowSet = new SlowSet<>();
		slowSet.add(3);
		slowSet.add(1);
		slowSet.add(2);
		System.out.println(slowSet);
	}

}
