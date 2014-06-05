package net.minixalpha.chap17;

import java.util.Iterator;

class SList<T> {
	private Link start = new Link();
	private Link end = start;

	public SListIterator iterator() {
		return new SListIterator();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		Link cur = start.next;
		while (cur != null) {
			builder.append(cur.value.toString() + " ");
			cur = cur.next;
		}
		return builder.toString();
	}

	class SListIterator implements Iterator<T> {

		private Link cur;

		public SListIterator() {
			cur = start;
		}

		@Override
		public boolean hasNext() {
			return cur != end;
		}

		@Override
		public T next() {
			if (cur != null) {
				cur = cur.next;
			}
			return cur.value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		public void add(T a) {
			Link newLink = new Link(a);
			end.addLink(newLink);
			end = newLink;
		}

	}

	class Link {
		Link next;
		T value;

		public Link() {
			this.next = null;
			this.value = null;
		}

		public Link(T a) {
			this.value = a;
			this.next = null;
		}

		public void addLink(Link newLink) {
			this.next = newLink;
		}
	}
}

public class Ex8 {

	static void testToString(SList<Integer> slist) {
		System.out.println(slist);
	}

	static void testIter(SList<Integer>.SListIterator iter) {
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public static void main(String[] args) {
		SList<Integer> slist = new SList<>();
		SList<Integer>.SListIterator iter = slist.iterator();
		iter.add(1);
		iter.add(3);
		testToString(slist);
		System.out.println("---");
		testIter(iter);

	}
}
