package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Ex11 {
	
	static void printIterator(Collection c) {
		Iterator iter = c.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(10);
		ints.add(11);
		printIterator(ints);
	}

}
