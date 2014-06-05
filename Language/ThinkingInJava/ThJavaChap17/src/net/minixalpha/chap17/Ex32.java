package net.minixalpha.chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class IntArray {
	private int[] data;
	private int capacity;
	private int size;

	public IntArray() {
		capacity = 10;
		size = 0;
		data = new int[capacity];
	}

	private void extendSize(int newCapacity) {
		data = Arrays.copyOf(data, newCapacity);
		capacity = newCapacity;
	}

	public void add(int d) {
		if (size >= capacity) {
			extendSize(capacity + (capacity >> 1));
		}
		data[size++] = d;
	}

	public int get(int i) {
		if (i < 0 || i >= size) {
			System.out.println(i + " " + size);
			throw new ArrayIndexOutOfBoundsException();
		}

		return data[i];
	}

	public void clear() {
		size = 0;
	}
}

public class Ex32 {

	static long test11(IntArray a, int loop, int size) {
		Random rand = new Random();
		long start = System.nanoTime();
		for (int i = 0; i < loop; i++) {
			a.clear();
			for (int j = 0; j < size; j++) {
				a.add(rand.nextInt());
			}
		}
		long duration = System.nanoTime() - start;
		return duration;
	}

	static long test12(IntArray a, int loop, int size) {
		Random rand = new Random();
		long start = System.nanoTime();
		for (int i = 0; i < loop; i++) {
			for (int j = 0; j < size; j++) {
				a.get(j);
			}
		}
		long duration = System.nanoTime() - start;
		return duration;
	}

	static void test1Run() {
		int loop = 1;
		int[] sizes = { 10, 100, 1000, 10000 };
		System.out.printf("%10s%10s%10s\n", "size", "add", "get");
		for (int i = 0; i < sizes.length; i++) {
			IntArray a = new IntArray();
			long addTime = test11(a, loop, sizes[i]);
			long getTime = test12(a, loop, sizes[i]);
			System.out.printf("%10d%10d%10d\n", sizes[i], addTime, getTime);
		}
	}

	static long test21(ArrayList<Integer> a, int loop, int size) {
		Random rand = new Random();
		long start = System.nanoTime();
		for (int i = 0; i < loop; i++) {
			a.clear();
			for (int j = 0; j < size; j++) {
				a.add(rand.nextInt());
			}
		}
		long duration = System.nanoTime() - start;
		return duration;
	}

	static long test22(ArrayList<Integer> a, int loop, int size) {
		Random rand = new Random();
		long start = System.nanoTime();
		for (int i = 0; i < loop; i++) {
			for (int j = 0; j < size; j++) {
				a.get(j);
			}
		}
		long duration = System.nanoTime() - start;
		return duration;
	}

	static void test2Run() {
		int loop = 1;
		int[] sizes = { 10, 100, 1000, 10000 };
		System.out.printf("%10s%10s%10s\n", "size", "add", "get");
		for (int i = 0; i < sizes.length; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			long addTime = test21(a, loop, sizes[i]);
			long getTime = test22(a, loop, sizes[i]);
			System.out.printf("%10d%10d%10d\n", sizes[i], addTime, getTime);
		}
	}

	public static void main(String[] args) {
		test1Run();
		System.out.println("---");
		test2Run();
	}
}