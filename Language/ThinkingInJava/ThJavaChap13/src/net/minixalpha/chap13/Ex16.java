package net.minixalpha.chap13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;

public class Ex16 {

	public static void main(String[] args) {
		args = new String[2];
		args[0] = "grep_dir";
		args[1] = "\\b[Ssct]\\w+";

		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1], Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher("");

		File[] files = new File(args[0]).listFiles();

		for (File file : files) {
			String path = file.getPath();
			System.out.println(path);
			for (String line : new TextFile(path)) {
				m.reset(line);
				while (m.find())
					System.out.println(index++ + ": " + m.group() + ": "
							+ m.start());
			}
			System.out.println("---");
		}
	}

}
