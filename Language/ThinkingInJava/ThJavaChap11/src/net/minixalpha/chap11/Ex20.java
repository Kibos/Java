
package net.minixalpha.chap11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex20 {

	public static void main(String[] args) {
		Set<String> wordsSet = new HashSet<String>();
		wordsSet.addAll(new TextFile("UniqueWords.java", "\\W+"));
		Character[] vowelsCharacters = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		Map<Character, Integer> vowelFreq = new HashMap<Character, Integer>();
		for (Character vowel: vowelsCharacters) {
			vowelFreq.put(vowel, 0);
		}
		
		for(String word: wordsSet) {
			for (int i=0; i<word.length(); i++) {
				for (int j=0; j<vowelsCharacters.length; j++) {
					Character c = vowelsCharacters[j];
					if (c == word.charAt(i)) {
						vowelFreq.put(c, vowelFreq.get(c) + 1);
					}
				}
			}
		}
		System.out.println(vowelFreq);
	}

}
