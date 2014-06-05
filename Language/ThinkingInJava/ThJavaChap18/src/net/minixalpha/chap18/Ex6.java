package net.minixalpha.chap18;

import java.io.File;
import java.io.IOException;

import net.mindview.util.Directory;

class ProcessFiles6 {
	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String ext;

	public ProcessFiles6(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;

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
						// Allow user to leave off extension:
						if (!arg.endsWith("." + ext))
							arg += "." + ext;
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			strategy.process(file.getCanonicalFile());
		}
	}

	// Demonstration of how to use it:
	public static void main(String[] args) {
		new ProcessFiles6(new ProcessFiles6.Strategy() {
			public void process(File file) {
				if (file.lastModified() > 1401282207000L) {
					System.out.println(file.lastModified());
					System.out.println(file);
				}
			}
		}, "java").start(args);
	}
}

public class Ex6 {
	public static void main(String[] args) {

	}
}
