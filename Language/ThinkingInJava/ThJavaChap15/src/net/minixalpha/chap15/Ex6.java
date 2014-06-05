package net.minixalpha.chap15;

import java.util.*;

class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random();

	public void add(T item) {
		storage.add(item);
	}

	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}

}

public class Ex6 {
	public static void main(String[] args) {
		RandomList<Integer> rs = new RandomList<Integer>();
		for (Integer s : Arrays.asList(1, 2, 3))
			rs.add(s);
		for (int i = 0; i < 11; i++)
			System.out.print(rs.select() + " ");
	}
}
