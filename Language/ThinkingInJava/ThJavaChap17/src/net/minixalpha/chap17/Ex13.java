package net.minixalpha.chap17;

import net.mindview.util.TextFile;

public class Ex13 {
	static AssociativeArray<String, Integer> testMap(String[] words) {
		AssociativeArray<String, Integer> map = new AssociativeArray<>(
				words.length);
		for (String wd : words) {
			Integer value = map.get(wd);
			if (value == null) {
				value = 0;
			}
			map.put(wd, value + 1);
		}
		return map;
	}

	public static void main(String[] args) {
		String content = TextFile.read("news.txt");
		String[] words = content.split("[, ]");
		AssociativeArray<String, Integer> map = testMap(words);
		System.out.println(map);
	}
}
