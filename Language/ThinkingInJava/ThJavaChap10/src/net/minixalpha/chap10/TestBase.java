
package net.minixalpha.chap10;

class TField {
	public TField(String s) {
		System.out.println(s);
	}
}

class TBase {
	TField s = new TField("TBase field");
	public TBase() {
		System.out.println("Tbase constructor");
	}
}

class TSub extends TBase {
	TField s = new TField("Tsub field");
	public TSub() {
		System.out.println("TSub constructor");
	}
}

public class TestBase {

	public static void main(String[] args) {
		TSub sub = new TSub();
	}

}
