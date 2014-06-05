
package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Ex19 {

	public static void main(String[] args) {
		Set<String> sets = new HashSet<String>();
		sets.add("harry");
		sets.add("ron");
		sets.add("hermonie");
		System.out.println(sets);
		
		List<String> list = new ArrayList<String>(sets);
		Collections.sort(list);
		System.out.println(list);
		
		LinkedHashSet<String> linkedSet = new LinkedHashSet<String>();
		for (String item: list) {
			linkedSet.add(item);
		}
		System.out.println(linkedSet);
	}

}
