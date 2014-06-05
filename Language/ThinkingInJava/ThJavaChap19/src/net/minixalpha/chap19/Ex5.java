package net.minixalpha.chap19;

import java.util.*;
import static net.mindview.util.Print.*;

class VowelsAndConsonants {
	enum Vowels {
		VOWEL('a', 'e', 'i', 'o', 'u'), SOMETIMES_A_VOWEL('y', 'w'), CONSONANT();

		private char[] values;

		private Vowels(char... items) {
			values = items;
		}

	};

	public static void main(String[] args) {
		Random rand = new Random(47);
		for (int i = 0; i < 100; i++) {
			int c = rand.nextInt(26) + 'a';
			printnb((char) c + ", " + c + ": ");
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				print("vowel");
				break;
			case 'y':
			case 'w':
				print("Sometimes a vowel");
				break;
			default:
				print("consonant");
			}
		}
	}
}

public class Ex5 {

	public static void main(String[] args) {
		// Can't understand what should I do.
	}

}
