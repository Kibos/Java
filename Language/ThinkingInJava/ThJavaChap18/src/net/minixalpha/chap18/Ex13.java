package net.minixalpha.chap18;

import java.io.*;

class BufferedInputFile {
	// Throw exceptions to console:
	public static String read(String filename) throws IOException {
		// Reading input by lines:
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null)
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.print(read("BufferedInputFile.java"));
	}
}

public class Ex13 {
	static String file = "BasicFileOutput.out";

	public static void main(String[] args) throws IOException {
		LineNumberReader in = new LineNumberReader(new StringReader(
				BufferedInputFile.read("BasicFileOutput.java")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				file)));
		String s;
		while ((s = in.readLine()) != null)
			out.println(in.getLineNumber() + ": " + s);
		out.close();
		// Show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}
}
