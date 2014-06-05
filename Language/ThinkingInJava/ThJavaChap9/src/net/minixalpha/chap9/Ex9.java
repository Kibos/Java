package net.minixalpha.chap9;

interface InstrumentEx9 {
	// Compile-time constant:
	int VALUE = 5; // static & final

	// Cannot have method definitions:
	void play(int n); // Automatically public

	void adjust();
}

abstract class InstrumentCommon {
	public void adjust() {
		System.out.println(this + ".adjust()");
	}
}

class WindEx9 extends InstrumentCommon implements InstrumentEx9 {
	public void play(int n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Wind";
	}

	
}

class Percussion extends InstrumentCommon implements InstrumentEx9 {
	public void play(int n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Percussion";
	}

}

class Stringed extends InstrumentCommon implements InstrumentEx9 {
	public void play(int n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Stringed";
	}

}

class Brass extends WindEx9 {
	public String toString() {
		return "Brass";
	}
}

class Woodwind extends WindEx9 {
	public String toString() {
		return "Woodwind";
	}
}

public class Ex9 {

	public static void main(String[] args) {
		WindEx9[] windEx9s = {
				new Brass(),
				new Woodwind()
		};
		
		for (WindEx9 windEx9: windEx9s) {
			windEx9.adjust();
		}
	}
}
