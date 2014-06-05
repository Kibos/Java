package net.minixalpha.chap12;

public class Ex27 {

	public static void main(String[] args) {
		try {
			Integer[] ia = { 1, 2 };
			int b = ia[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException(e);
		}
	}

}
