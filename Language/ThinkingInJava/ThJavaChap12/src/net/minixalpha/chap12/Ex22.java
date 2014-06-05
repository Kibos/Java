package net.minixalpha.chap12;

class Base22 {
	public Base22() {
		throw new NullPointerException();
	}
}

public class Ex22 {
	public static void main(String[] args) {
		try {
			Base22 base22 = new Base22();
		} catch (NullPointerException e) {
			System.out.println("catch it");
			e.printStackTrace();
		}
	}
}
