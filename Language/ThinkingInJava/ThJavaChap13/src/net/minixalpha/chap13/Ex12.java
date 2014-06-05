package net.minixalpha.chap13;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

class Groups {
	static public final String POEM = "Twas brillig, and the slithy toves\n"
			+ "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n"
			+ "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwock, my son,\n"
			+ "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n"
			+ "The frumious Bandersnatch.";

	public static void main(String[] args) {
		Matcher m = Pattern.compile("\\s+([a-z]\\S+)\\b+\\n*").matcher(POEM);
		Set<String> wordsSet = new HashSet<String>();
		while (m.find()) {
			for (int j = 1; j <= m.groupCount(); j++) {
				wordsSet.add(m.group(j));
				System.out.print("[" + m.group(j) + "]");
			}
			System.out.println();
		}
		System.out.println(wordsSet.size());
	}
}

public class Ex12 {

	public static void main(String[] args) {

	}

}
