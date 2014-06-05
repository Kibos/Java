package net.minixalpha.chap10;

class Sequence2 {
	private Object[] items;
	private int next = 0;

	public Sequence2(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length)
			items[next++] = x;
	}

	private class SequenceSelector2 implements Selector {
		private int i = 0;

		public boolean end() {
			return i == next;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if (i < items.length)
				i++;
		}
		
		public Sequence2 getOuter() {
			return Sequence2.this;
		}
	}

	public Selector selector() {
		return new SequenceSelector2();
	}
}


public class Ex4 {
	public static void main(String[] args) {
		Sequence2 sequence = new Sequence2(10);
		for (int i = 0; i < 9; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
