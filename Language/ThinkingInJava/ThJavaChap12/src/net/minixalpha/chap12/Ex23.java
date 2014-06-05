package net.minixalpha.chap12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Base23 {
	List<Integer> ints1 = null;
	List<Integer> ints2 = null;
	Random random = new Random();

	public Base23() throws Exception {
		ints1 = new ArrayList<>();
		if (random.nextInt(2) == 0) {
			ints1.get(1);
		}
		ints2 = new ArrayList<>();
	}

	public void disposal() {
		ints1 = null;
		ints2 = null;
	}

	public List<Integer> getInts1() {
		return ints1;
	}

	public List<Integer> getInts2() {
		return ints2;
	}
}

public class Ex23 {
	public static void main(String[] args) {
		Base23 base23 = null;
		try {
			base23 = new Base23();
			base23.disposal();
			System.out.println(base23.getInts1() == null);
		} catch (Exception e) {
			System.out.println("catch 1");
		}
	}
}
