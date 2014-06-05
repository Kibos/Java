
package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex12 {

	public static void main(String[] args) {
		List<Integer> ints1 = new ArrayList<>();
		for (int i=0; i<10; i++) {
			ints1.add(i);
		}
		
		List<Integer> ints2 = new ArrayList<>();
		for (int i=10; i<20; i++) {
			ints2.add(i);
		}
		
		System.out.println(ints1);
		System.out.println(ints2);
		
//		for (int i=9; i>=0; i--) {
//			ints2.add(ints1.get(i));
//		}
		
		ListIterator<Integer> iterator = ints1.listIterator(ints1.size());
		while (iterator.hasPrevious()) {
			ints2.add(iterator.previous());
		}
		
		System.out.println(ints2);
	}

}
