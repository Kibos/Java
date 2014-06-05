package net.minixalpha.chap12;

import java.util.Random;

public class Ex13 {

	public static void main(String[] args) {
		Random random = new Random();
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println(e.getClass());
		} finally {
			System.out.println("hijack");
		}
	}
}
