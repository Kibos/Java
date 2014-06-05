package net.minixalpha.chap12;

class TooMuchElementsException extends Exception {
	public TooMuchElementsException(String msg) {
		super(msg);
	}
}

interface Selector {
	boolean end();

	Object current();

	void next();
}

class Sequence {
	private Object[] items;
	private int next = 0;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object x) throws TooMuchElementsException {
		if (next < items.length)
			items[next++] = x;
		else {
			throw new TooMuchElementsException("" + next);
		}
	}

	private class SequenceSelector implements Selector {
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

	public Selector selector() {
		return new SequenceSelector();
	}

}

public class Ex12 {

	public static void main(String[] args) {
		Sequence sequence = new Sequence(2);
		try {
			for (int i = 0; i < 10; i++)
				sequence.add(Integer.toString(i));
		} catch (TooMuchElementsException e) {
			e.printStackTrace();
		}
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}

}
