package net.minixalpha.chap18;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import net.mindview.util.Directory;

class ProcessFiles5 {
	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String regex;
	private Pattern pattern;

	public ProcessFiles5(Strategy strategy, String regex) {
		this.strategy = strategy;
		this.regex = regex;
		this.pattern = Pattern.compile(regex);
	}

	public void start(String[] args) {
		try {
			if (args.length == 0)
				processDirectoryTree(new File("."));
			else
				for (String arg : args) {
					File fileArg = new File(arg);
					if (fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						if (pattern.matcher(arg).matches()) {
							strategy.process(new File(arg).getCanonicalFile());
						}
					}
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		for (File file : Directory.walk(root.getAbsolutePath(), regex))
			strategy.process(file.getCanonicalFile());
	}

	// Demonstration of how to use it:
	public static void main(String[] args) {
		new ProcessFiles5(new ProcessFiles5.Strategy() {
			public void process(File file) {
				System.out.println(file);
			}
		}, ".*Ex[1-9]+\\.java").start(args);
	}
}

public class Ex5 {
	public static void main(String[] args) {
		ProcessFiles5.main(args);
	}
}
