package net.minixalpha.chap11;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ex9 {
	public class Sequence<E> {
		private Object[] items;
		private int next = 0;

		public Sequence(int size) {
			items = new Object[size];
		}

		public void add(Object x) {
			if (next < items.length)
				items[next++] = x;
		}

		private class SequenceSelector implements Iterator<E> {
			private int i = 0;
			private int preI = -1;

			public Object current() {
				return items[i];
			}

			public E next() {
				if (i >= next) {
					throw new NoSuchElementException();
				}
				preI = i;
				i = i + 1;
				return (E)items[preI];
			}

			@Override
			public boolean hasNext() {
				return i != next;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		}

		public Iterator<E> iterator() {
			return new SequenceSelector();
		}

	}

	public static void main(String[] args) {
		Ex9 ex9 = new Ex9();
		Sequence sequence = ex9.new Sequence(10);
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Iterator iterator = sequence.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

}
