package net.minixalpha.chap15;

import java.util.ArrayList;
import java.util.List;

public class Ex27 {
	public static void main(String[] args) {
		List<? extends Number> numbers = new ArrayList<Integer>();
//		numbers.add(1);
		numbers.add(null);
	}
}
