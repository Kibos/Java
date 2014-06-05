package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ForEx7 {
	String x;

	public ForEx7(String x) {
		this.x = x;
	}

	public String toString() {
		return x;
	}
}

public class Ex7 {

	public static void main(String[] args) {
		ForEx7[] forEx7s = { new ForEx7("foo"), new ForEx7("bar"),
				new ForEx7("gae"), new ForEx7("sae") };
		List<ForEx7> forEx7s2 = new ArrayList<ForEx7>();
		for (ForEx7 f: forEx7s) {
			forEx7s2.add(f);
		}
		
		List<ForEx7> sub2 = forEx7s2.subList(1, 3);
		System.out.println(forEx7s2);
		System.out.println(sub2);
		forEx7s2.removeAll(sub2);
		System.out.println(forEx7s2);
//		System.out.println(sub2); 
		// can not access as elements in sub2 is removed,
		// which means that sub2 is part of forEx7s2,
		// not a new copy
	}
}
