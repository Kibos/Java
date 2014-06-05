
package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex18 {

	public static void main(String[] args) {
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("cd", 12);
		maps.put("ab", 45);
		maps.put("gb", 32);
		System.out.println(maps);
		
		Set<String> set = maps.keySet();
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		System.out.println(list);
		
		Map<String, Integer> sortedMaps = new LinkedHashMap<String, Integer>();
		for (String key: list) {
			sortedMaps.put(key, maps.get(key));
		}
		System.out.println(sortedMaps);
	}

}
