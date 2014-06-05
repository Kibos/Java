package net.minixalpha.chap18;

import java.io.File;
import java.io.IOException;
import java.util.*;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;

public class Ex20 {

	static boolean bytesEqual(byte[] a, byte b[]) {

		if (a.length != b.length) {
			return false;
		}
		int len = Math.min(a.length, b.length);
		for (int i = 0; i < len; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		List<File> files = Directory.walk(".").files;
		byte[] classBytes = { (byte) 0xCA, (byte) 0xFE, (byte) 0xBA,
				(byte) 0xBE };

		System.out.println(Arrays.toString(classBytes));
		for (File f : files) {
			if (f.getName().endsWith(".class")) {
				System.out.print(f.getName() + ":");
				byte[] bytes = BinaryFile.read(f);
				byte[] subBytes = new byte[4];
				for (int i = 0; i < 4; i++) {
					subBytes[i] = bytes[i];
				}
				System.out.println(bytesEqual(classBytes, subBytes));
			}
		}
	}
}
