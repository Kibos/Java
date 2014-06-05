package net.minixalpha.chap16;

import java.util.Arrays;

class Ex19Demo {
	int id;

	public Ex19Demo(int id) {
		this.id = id;
	}
}

class Ex19Demo2 {
	private int id;

	public Ex19Demo2(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Ex19Demo2) obj).getID();
	}
}

public class Ex19 {

	static void testCase1() {
		Ex19Demo[] demos = { new Ex19Demo(0), new Ex19Demo(1) };
		Ex19Demo[] demos2 = { new Ex19Demo(0), new Ex19Demo(1) };

		System.out.println(Arrays.equals(demos, demos2));
	}

	static void testCase2() {
		Ex19Demo2[] demos = { new Ex19Demo2(0), new Ex19Demo2(1) };
		Ex19Demo2[] demos2 = { new Ex19Demo2(0), new Ex19Demo2(1) };

		System.out.println(Arrays.equals(demos, demos2));
	}

	public static void main(String[] args) {
		testCase1();
		testCase2();
	}
}
