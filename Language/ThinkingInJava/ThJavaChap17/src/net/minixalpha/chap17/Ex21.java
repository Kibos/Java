package net.minixalpha.chap17;

public class Ex21 {
	public static void main(String[] args) {
		// See new version of SimpleHashMap in Ex19.java
		SimpleHashMap<Integer, String> simpleMap = new SimpleHashMap<>();
		Integer integer = new Integer(23);
		String str = new String("49");
		for (int i = 0; i < 3; i++) {
			simpleMap.put(integer, str);
		}
	}
}
