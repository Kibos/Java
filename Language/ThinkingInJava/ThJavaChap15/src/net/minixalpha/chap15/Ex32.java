package net.minixalpha.chap15;

class FixedSizeStack<T> {
	private int index = 0;
	private Object[] storage;

	public FixedSizeStack(int size) {
		storage = new Object[size];
	}

	public void push(T item) {
		storage[index++] = item;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		return (T) storage[--index];
	}
}

class GenericCast {
	public static final int SIZE = 1;

	public static void main(String[] args) {
		FixedSizeStack2<String> strings = new FixedSizeStack2<String>(SIZE);
		for (String s : "A B C D E F G H I J".split(" "))
			strings.push(s);
		for (int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}
	}
}

public class Ex32 {

	public static void main(String[] args) {
		// If you want to do something when ArrayIndexOutOfBoundsException,
		// you should check it.
	}

}
