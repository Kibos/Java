package net.minixalpha.chap12;

class OnOffSwitch {
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
			sw.off();
			
		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
			sw.off();
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
			sw.off();
		}
	}
}

public class Ex14 {

	public static void main(String[] args) {
		OnOffSwitch.main(null);
	}

}
