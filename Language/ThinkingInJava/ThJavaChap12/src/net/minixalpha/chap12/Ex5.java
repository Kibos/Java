package net.minixalpha.chap12;

public class Ex5 {

	public static void main(String[] args) {
		boolean hasException = true;
		int index = 4;

		while (hasException) {
			try {
				Integer[] ia = { 1, 2 };
				int b = ia[index--];
				hasException = false;
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
	}

}
