package net.minixalpha.chap13;

import java.util.regex.*;

public class Ex15 {

	public static void main(String[] args) {
		args = new String[2];
		args[0] = "JGrep.java";
		args[1] = "\\b[Ssct]\\w+";

		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1], Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher("");
		for (String line : new TextFile(args[0])) {
			m.reset(line);
			while (m.find())
				System.out.println(index++ + ": " + m.group() + ": "
						+ m.start());
		}
	}

}
