package net.minixalpha.chap17;

import java.util.*;
import static net.mindview.util.Print.*;

class CountedString26 {
	private static List<String> created = new ArrayList<String>();
	private String s;
	private int id = 0;
	private char tchar;

	public CountedString26(String str, char tchar) {
		s = str;
		created.add(s);
		// id is the total number of instances
		// of this string in use by CountedString26:
		for (String s2 : created)
			if (s2.equals(s))
				id++;
		this.tchar = tchar;
	}

	public String toString() {
		return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
	}

	public int hashCode() {
		// The very simple approach:
		// return s.hashCode() * id;
		// Using Joshua Bloch's recipe:
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		result = 37 * result + tchar;
		return result;
	}

	public boolean equals(Object o) {
		return o instanceof CountedString26
				&& s.equals(((CountedString26) o).s)
				&& id == ((CountedString26) o).id
				&& tchar == ((CountedString26) o).tchar;
	}

	public static void main(String[] args) {
		Map<CountedString26, Integer> map = new HashMap<CountedString26, Integer>();
		CountedString26[] cs = new CountedString26[5];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString26("hi", 'h');
			map.put(cs[i], i); // Autobox int -> Integer
		}
		print(map);
		for (CountedString26 cstring : cs) {
			print("Looking up " + cstring);
			print(map.get(cstring));
		}
	}
}

public class Ex26 {
	public static void main(String[] args) {
		CountedString26.main(null);
	}
}
