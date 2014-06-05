package net.minixalpha.chap12;

class OnOffSwitchX {
	private static Switch sw = new Switch();

	public static void f() throws OnOffException1, OnOffException2 {
	}

	public static void g() {
		throw new RuntimeException();
	}

	public static void main(String[] args) {
		try {

			sw.on();
			// Code that can throw exceptions...
			g();
			f();

		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
			sw.off();
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
		} finally {
			sw.off();
		}
	}
}

public class Ex15 {

	public static void main(String[] args) {
		OnOffSwitchX.main(null);
	}

}
