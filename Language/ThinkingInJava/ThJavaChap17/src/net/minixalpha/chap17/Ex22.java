package net.minixalpha.chap17;

public class Ex22 {
	public static void main(String[] args) {
		// See new version of SimpleHashMap in Ex19.java
		SimpleHashMap<Integer, String> simpleMap = new SimpleHashMap<>();
		simpleMap.put(23, "asd");
		simpleMap.put(59, "23f");
		System.out.println(simpleMap);
		simpleMap.remove(23);
		System.out.println(simpleMap);
		simpleMap.clear();
		System.out.println(simpleMap);
	}
}
