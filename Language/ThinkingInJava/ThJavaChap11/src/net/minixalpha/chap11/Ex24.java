
package net.minixalpha.chap11;

import java.util.*;

class ex24Demo {
	String name;
	
	public ex24Demo(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}

public class Ex24 {

	public static void main(String[] args) {
		Map<String, ex24Demo> lhm = new LinkedHashMap<>();
		lhm.put("foo", new ex24Demo("bar"));
		lhm.put("arry", new ex24Demo("ron"));
		System.out.println(lhm);
		
		Set<String> keySet = lhm.keySet();
		List<String> keyList = new ArrayList<String>(keySet);
		Collections.sort(keyList);
		
		Map<String, ex24Demo> hMap = new HashMap<String, ex24Demo>(lhm);
		lhm.clear();
		
		for(String key: keyList) {
			lhm.put(key, hMap.get(key));
		}
		System.out.println(lhm);
	}

}
