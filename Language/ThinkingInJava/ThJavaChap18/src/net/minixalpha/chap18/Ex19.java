package net.minixalpha.chap18;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.mindview.util.BinaryFile;

public class Ex19 {
	public static void main(String[] args) throws IOException {
		byte[] bytes = BinaryFile.read("test.txt");
		Map<Byte, Integer> byteMap = new HashMap<Byte, Integer>();

		for (int i = 0; i < bytes.length; i++) {
			Byte b = bytes[i];
			Integer value = byteMap.get(b);
			if (value == null) {
				value = 0;
			}
			byteMap.put(b, value + 1);
		}

		System.out.println(byteMap);
	}
}
