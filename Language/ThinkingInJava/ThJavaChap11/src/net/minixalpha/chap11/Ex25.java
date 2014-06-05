package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex25 {

	public static void main(String[] args) {
		List<String> wordsList = new ArrayList<String>();
		wordsList.addAll(new TextFile("UniqueWords.java", "\\W+"));
		Collections.sort(wordsList, String.CASE_INSENSITIVE_ORDER);

		Map<String, ArrayList<Integer>> wordsPos = new HashMap<String, ArrayList<Integer>>();

		int seq = 0;
		for (String word : wordsList) {
			ArrayList<Integer> posList = wordsPos.get(word);
			if (posList == null) {
				posList = new ArrayList<Integer>();
				wordsPos.put(word, posList);
			}
			posList.add(seq);
			seq += 1;
		}

		System.out.println(wordsPos);

	}

}
