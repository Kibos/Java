package net.minixalpha.chap18;

import java.util.HashMap;
import java.util.Map;

import net.mindview.util.TextFile;

public class Ex17 {
	public static void main(String[] args) {
		String fileContent = TextFile.read("test.txt");
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < fileContent.length(); i++) {
			Character c = fileContent.charAt(i);
			Integer value = map.get(c);
			if (value == null) {
				value = 0;
			}
			map.put(c, value + 1);
		}

		System.out.println(map);
	}
}
