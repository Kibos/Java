
package net.minixalpha.chap11;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ex16 {

	public static void main(String[] args) {
		Set<String> wordsSet = new HashSet<String>();
		wordsSet.addAll(new TextFile("UniqueWords.java", "\\W+"));
		
		Character[] vowelsCharacters = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		
		int vowelTotalNum = 0;
		
		for(String word: wordsSet) {
			int vowelNum = 0;
			for (int i=0; i<word.length(); i++) {
				for (int j=0; j<vowelsCharacters.length; j++) {
					if (word.charAt(i) == vowelsCharacters[j]) {
						vowelNum += 1;
					}
				}
			}
			System.out.println(word + " " + vowelNum);
			vowelTotalNum += vowelNum;
		}
		
		System.out.println("Vowel Total Num: " + vowelTotalNum);
	}

}
