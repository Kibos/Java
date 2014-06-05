package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;

class Ex41Demo implements Comparable<Ex41Demo> {
	private static RandomGenerator.String genString = new RandomGenerator.String();
	public String aString = genString.next();
	public String bString = genString.next();

	public Ex41Demo() {
		// TODO Auto-generated constructor stub
	}

	public Ex41Demo(String a, String b) {
		aString = a;
		bString = b;
	}

	@Override
	public int compareTo(Ex41Demo o) {
		return aString.compareTo(o.aString);
	}

	@Override
	public String toString() {
		return "(" + aString + "," + bString + ")";
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash = 37 * hash + aString.hashCode();
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ex41Demo)) {
			return false;
		}

		Ex41Demo demoObj = (Ex41Demo) obj;

		return aString.equals(demoObj.aString);
	}
}

public class Ex41 {
	public static void main(String[] args) {
		Set<Ex41Demo> set = new HashSet<>();
		set.add(new Ex41Demo());
		set.add(new Ex41Demo());
		System.out.println(set);

		Map<Ex41Demo, String> map = new HashMap<Ex41Demo, String>();
		map.put(new Ex41Demo(), "demo1");
		map.put(new Ex41Demo(), "demo2");
		System.out.println(map);
	}
}
