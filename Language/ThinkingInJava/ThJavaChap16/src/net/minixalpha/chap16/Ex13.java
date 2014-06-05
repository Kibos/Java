package net.minixalpha.chap16;

import net.mindview.util.CountingGenerator;

public class Ex13 {
	
	public static void main(String[] args) {
		char[] buf = new char[3];
		CountingGenerator.Character cGen = new CountingGenerator.Character();
		for (int i = 0; i < 3; i++) {
			buf[i] = cGen.next();
		}
		System.out.println(new String(buf));
	}
}
