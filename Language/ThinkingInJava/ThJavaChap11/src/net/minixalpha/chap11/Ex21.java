package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex21 {

	public static void main(String[] args) {
		List<String> wordsList = new ArrayList<String>();
		wordsList.addAll(new TextFile("UniqueWords.java", "\\W+"));
		Collections.sort(wordsList, String.CASE_INSENSITIVE_ORDER);

		Map<String, Integer> wordsFeq = new HashMap<String, Integer>();

		for (String word : wordsList) {
			Integer feq = wordsFeq.get(word);
			wordsFeq.put(word, feq == null ? 1 : feq + 1);
		}

		for (String word : wordsList) {
			System.out.println(word + ":" + wordsFeq.get(word));
		}

	}

}
