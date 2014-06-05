package net.minixalpha.chap13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex17 {
	public static void main(String[] args) {
		args = new String[2];
		args[0] = "JGrep.java";
		// args[1] = "//(.*)";
		args[1] = "/\\*(.*?)\\*/";

		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1], Pattern.DOTALL);
		// Iterate through the lines of the input file:
		int index = 0;
		String content = TextFile.read(args[0]);

		// System.out.println(content);

		Matcher m = p.matcher(content);

		while (m.find()) {
			System.out.println( m.group());
			System.out.println("--");
		}
	}

}
