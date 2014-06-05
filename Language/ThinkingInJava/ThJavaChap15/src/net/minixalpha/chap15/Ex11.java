package net.minixalpha.chap15;

import java.util.HashMap;
import java.util.Map;

class New {
	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}
}

class Ex11Demo {

}

public class Ex11 {
	public static void main(String[] args) {
		Map<Ex11Demo, Integer> map = New.map();
		Ex11Demo key = new Ex11Demo();
		map.put(key, 3);
		System.out.println(map.get(key));
	}

}
