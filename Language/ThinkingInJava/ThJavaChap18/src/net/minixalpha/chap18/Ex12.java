package net.minixalpha.chap18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Ex12 {
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.err.println("Input file name");
			System.exit(1);
		}
		String name = args[0];
		BufferedReader reader = new BufferedReader(new FileReader(name));

		LinkedList<String> lines = new LinkedList<>();
		String line;

		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}

		int lineNum = 1;
		PrintWriter writer = new PrintWriter(name + ".bak");
		Object[] lineArray = lines.toArray();
		for (int i = lines.size() - 1; i >= 0; i--) {
			writer.write(lineNum + ":" + (String) lineArray[i] + "\n");
			lineNum++;
		}
		writer.close();
		reader.close();
	}

}
