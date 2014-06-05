
package net.minixalpha.chap11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Ex17 {

	public static void main(String[] args) {
		Map<String, Gerbil> gerMap = new HashMap<String, Gerbil>();
		gerMap.put("tom", new Gerbil(1));
		gerMap.put("jack", new Gerbil(2));
		
		Iterator<String> iterator = gerMap.keySet().iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			Gerbil gerbil = gerMap.get(name);
			System.out.println(name);
			gerbil.hop();
		}
	}

}
