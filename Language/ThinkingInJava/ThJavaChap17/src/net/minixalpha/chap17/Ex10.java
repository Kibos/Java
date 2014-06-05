package net.minixalpha.chap17;

import java.security.acl.LastOwnerException;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

class MySortedSet<T> implements Set<T> {
	private List<T> dataList = new LinkedList<T>();

	public Object first() {
		return dataList.get(0);
	}

	public Object last() {
		return dataList.get(dataList.size() - 1);
	}

	public MySortedSet() {
		// TODO Auto-generated constructor stub
	}

	public MySortedSet(Collection<T> cs) {
		for (T c : cs) {
			dataList.add(c);
		}
	}

	public MySortedSet<T> subList(int fromIndex, int toIndex) {
		return new MySortedSet<>(dataList.subList(fromIndex, toIndex));
	}

	public MySortedSet<T> headSet(T toElement) {
		MySortedSet<T> head = new MySortedSet<>();
		Comparable<T> cmp = (Comparable<T>) toElement;

		for (T data : dataList) {
			if (cmp.compareTo(data) < 0) {
				break;
			}
			head.add(data);
		}
		return head;
	}

	public MySortedSet<T> tailSet(T fromElement) {
		MySortedSet<T> tail = new MySortedSet<>();
		int size = dataList.size();
		Comparable<T> cmp = (Comparable<T>) fromElement;

		for (int i = size - 1; i >= 0; i--) {
			T t = dataList.get(i);

			if (cmp.compareTo(t) > 0) {
				break;
			}
			tail.add(t);
		}
		return tail;
	}

	@Override
	public int size() {
		return dataList.size();
	}

	@Override
	public boolean isEmpty() {
		return dataList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return dataList.indexOf(o) != -1;
	}

	@Override
	public Iterator<T> iterator() {
		return dataList.iterator();
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(T e) {
		Comparable<T> te = (Comparable<T>) e;
		int i;
		for (i = 0; i < dataList.size(); i++) {
			if (te.compareTo(dataList.get(i)) < 0) {
				break;
			}
		}

		dataList.add(i, e);
		return false;
	}

	public String toString() {
		return dataList.toString();
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
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

	}

}

public class Ex10 {
	public static void main(String[] args) {
		MySortedSet<Integer> set = new MySortedSet<>();
		set.add(3);
		set.add(1);
		set.add(2);

		System.out.println(set);

		System.out.println(set.first());
		System.out.println(set.last());
		System.out.println(set.subList(0, 2));
		System.out.println(set.headSet(2));
		System.out.println(set.tailSet(2));
	}
}
