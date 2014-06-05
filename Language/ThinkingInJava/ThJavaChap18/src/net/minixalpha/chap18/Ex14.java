package net.minixalpha.chap18;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex14 {
	static void test(Writer writer, int loops, String line) throws IOException {

		long startTime = System.nanoTime();
		for (int i = 0; i < loops; i++) {
			writer.write(line);
		}
		writer.close();
		System.out.println(writer.getClass() + ":"
				+ (System.nanoTime() - startTime));
	}

	public static void main(String[] args) throws IOException {
		String name1 = "Ex14.out.1";
		String name2 = "Ex14.out.2";
		int loops = 100;
		String line = "test\n";

		File file = new File(name1);
		test(new PrintWriter(file), loops, line);

		File file2 = new File(name2);
		test(new PrintWriter(new BufferedWriter(new FileWriter(file2))), loops,
				line);
	}
}
