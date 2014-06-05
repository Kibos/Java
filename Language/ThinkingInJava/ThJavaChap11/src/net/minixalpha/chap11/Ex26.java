package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex26 {

	public static void main(String[] args) {
		List<String> wordsList = new ArrayList<String>();
		wordsList.addAll(new TextFile("UniqueWords.java", "\\W+"));

		Map<String, ArrayList<Integer>> wordsPos = new HashMap<String, ArrayList<Integer>>();

		int seq = 0;
		for (String word : wordsList) {
			ArrayList<Integer> posList = wordsPos.get(word);
			if (posList == null) {
				posList = new ArrayList<Integer>();

			}
			posList.add(seq);
			wordsPos.put(word, posList);
			seq += 1;
		}

		System.out.println(wordsPos);

		Collection<ArrayList<Integer>> valueSet = wordsPos.values();
		int count = 0;
		for (ArrayList<Integer> pos : valueSet) {
			count += pos.size();
		}
		System.out.println(count);

		Collection<String> keySet = wordsPos.keySet();
		for (int i = 0; i < count; i++) {
			for (String key : keySet) {
				if (wordsPos.get(key).contains(i)) {
					System.out.println(key);
				}
			}
		}

	}

}
