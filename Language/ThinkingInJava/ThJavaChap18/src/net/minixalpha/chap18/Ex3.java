package net.minixalpha.chap18;

import java.util.regex.*;
import java.io.*;
import java.util.*;

class DirList {
	static int totalFileSize(String[] paths) {
		int totalSize = 0;
		for(String path: paths) {
			File file = new File(path);
			totalSize += file.length();
		}
		return totalSize;
	}
	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFilter3(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
		System.out.println("file size " + totalFileSize(list));
	}
}

class DirFilter3 implements FilenameFilter {
	private Pattern pattern;

	public DirFilter3(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}

public class Ex3 {
	public static void main(String[] args) {
		
	}
}