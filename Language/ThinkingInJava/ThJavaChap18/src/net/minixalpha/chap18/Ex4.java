package net.minixalpha.chap18;

import java.io.File;
import java.util.List;

import net.mindview.util.Directory;

public class Ex4 {
	public static void main(String[] args) {
		List<File> files = Directory.walk(".").files;
		int totalSize = 0;
		for (File f : files) {
			totalSize += f.length();
		}
		System.out.println(totalSize);
	}
}
