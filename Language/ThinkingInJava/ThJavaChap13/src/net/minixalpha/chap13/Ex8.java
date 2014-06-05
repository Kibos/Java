package net.minixalpha.chap13;

import java.util.Arrays;

class Splitting {
	public static String knights = "Then, when you have found the shrubbery, you must "
			+ "cut down the mightiest tree in the forest... "
			+ "with... a herring!";

	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));
	}

}

public class Ex8 {

	public static void main(String[] args) {
		// Splitting.split(" "); // Doesn't have to contain regex chars
		// Splitting.split("\\W+"); // Non-word characters
		// Splitting.split("n\\W+"); // 'n' followed by non-word characters
		Splitting.split("the | you");
	}

}
