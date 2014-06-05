package net.minixalpha.chap13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex19 {
	public static void main(String[] args) {
		args = new String[2];
		args[0] = "JGrep.java";
		// args[1] = "//(.*)";
		args[1] = "class {1,}([0-9a-zA-Z_]+)";

		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1], Pattern.CASE_INSENSITIVE);
		// Iterate through the lines of the input file:
		int index = 0;
		String content = TextFile.read(args[0]);

		// System.out.println(content);

		Matcher m = p.matcher(content);

		while (m.find()) {
			System.out.println(m.group(1));
			for (int i = 1; i < m.groupCount(); i++) {
				System.out.println(m.group(i));
			}
		}
	}
}
