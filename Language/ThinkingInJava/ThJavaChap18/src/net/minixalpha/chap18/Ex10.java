package net.minixalpha.chap18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Ex10 {
	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.err.println("Input file name and word to look up");
			System.exit(1);
		}
		String name = args[0];
		String word = args[1];

		BufferedReader reader = new BufferedReader(new FileReader(name));
		LinkedList<String> lines = new LinkedList<>();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.indexOf(word) != -1) {
				lines.add(line);
			}
		}

		Object[] lineArray = lines.toArray();
		for (int i = lines.size() - 1; i >= 0; i--) {
			System.out.println(lineArray[i]);
		}
		reader.close();
	}
}
