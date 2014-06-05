package net.minixalpha.chap18;

import java.util.regex.*;
import java.io.*;
import java.util.*;

import net.mindview.util.TextFile;

class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name) {
		String path = dir.getPath() + "/" + name;
		File file = new File(path);
		if (file.isFile()) {
			String content = TextFile.read(path);
			return pattern.matcher(content).matches();
		} else {
			return false;
		}
	}
}

public class Ex1 {

	static void testCase1(String[] args) {
		File path = new File(".");
		String[] list;
		args = new String[1];
		args[0] = "^t.+\n";
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFilter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}

	public static void main(String[] args) {
		testCase1(args);
	}
}
