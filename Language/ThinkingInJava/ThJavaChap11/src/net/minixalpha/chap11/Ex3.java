package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Collections;

interface Selector {
	boolean end();

	Object current();

	void next();
}

class Sequence {
	private ArrayList items;
	private int next = 0;

	public Sequence(int size) {
		items = new ArrayList(size);
	}

	public void add(Object x) {
		items.add(x);
	}

	private class SequenceSelector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == items.size();
		}

		public Object current() {
			return items.get(i);
		}

		public void next() {
			if (i < items.size())
				i++;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 20; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}

public class Ex3 {
	public static void main(String[] args) {
		Sequence.main(null);
	}
}
