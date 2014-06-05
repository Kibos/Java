package net.minixalpha.chap14;

import net.mindview.util.New;

public class Ex13 {

	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Part.class);
		int n = 10;
		for (int i=0; i<n; i++) {
			counter.count(Part.createRandom());
		}
		System.out.println(counter);
	}

}
