package net.minixalpha.chap18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Ex7 {
	public static void main(String[] args) throws IOException {
		String name = "test.txt";
		BufferedReader reader = new BufferedReader(new FileReader(name));
		LinkedList<String> lines = new LinkedList<>();
		String line;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}

		Object[] lineArray =  lines.toArray();
		for (int i = lines.size() - 1; i >= 0; i--) {
			System.out.println(lineArray[i]);
		}
		reader.close();
	}
}
