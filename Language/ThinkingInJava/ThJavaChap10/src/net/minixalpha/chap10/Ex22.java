package net.minixalpha.chap10;

interface SelectorEx22 {
	boolean end();

	Object current();

	void next();
}

class SequenceEx22 {
	private Object[] items;
	private int next = 0;

	public SequenceEx22(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length)
			items[next++] = x;
	}

	private class SequenceSelector implements SelectorEx22 {
		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if (i < items.length)
				i++;
		}
	}

	private class ReverseSequenceSelector implements SelectorEx22 {
		private int i = items.length - 1;

		@Override
		public boolean end() {
			return i == -1;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if (i >= 0) {
				i--;
			}
		}

	}

	public SelectorEx22 selector() {
		return new SequenceSelector();
	}

	public SelectorEx22 reverseSelector() {
		return new ReverseSequenceSelector();
	}
}

public class Ex22 {

	public static void main(String[] args) {
		SequenceEx22 sequence = new SequenceEx22(10);
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		SelectorEx22 selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		
		System.out.println();
		
		SelectorEx22 reverSelectorEx22 = sequence.reverseSelector();
		while (!reverSelectorEx22.end()) {
			System.out.print(reverSelectorEx22.current() + " ");
			reverSelectorEx22.next();
		}
	}

}
