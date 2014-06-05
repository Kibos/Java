package net.minixalpha.chap12;

class Base24 {
	public Base24() {
		throw new NullPointerException();
	}

	public void disposal() {
		System.out.println("disposal");
	}
}

public class Ex24 {
	public static void main(String[] args) {
		try {
			Base24 base24 = new Base24();
			try {

			} finally {
				base24.disposal();
			}
		} catch (NullPointerException e) {
			System.out.println("catch it");
			e.printStackTrace();
		}
	}
}
