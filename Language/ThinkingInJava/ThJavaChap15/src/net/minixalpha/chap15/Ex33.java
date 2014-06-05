package net.minixalpha.chap15;

import java.util.ArrayList;

class FixedSizeStack2<T> {
	private int index = 0;
	private ArrayList<Object> storage;

	public FixedSizeStack2(int size) {
		index++;
		storage = new ArrayList<Object>(size);
	}

	public void push(T item) {
		storage.add(item);
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		return (T) storage.remove(--index);
	}
}

class GenericCast2 {
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

public class Ex33 {

}
