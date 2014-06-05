/**
 * @author minix
 * @Date Jun 10, 2013 23:05:27 PM
 * @Description
 *		Exercise 6: (1) Change Music3.java so that toString( ) becomes the root Object method
		toString( ). Try System.out.printlning the Instrument objects using System.out.System.out.printlnln( ) (without
		any casting)
 */

package net.minixalpha.chap8;

enum Note {
	MIDDLE_C, C_SHARP, B_FLAT; // Etc.
} // /:~

class Instrument {
	void play(Note n) {
		System.out.println("Instrument.play() " + n);
	}

	public String toString() {
		return "Instrument";
	}

	void adjust() {
		System.out.println("Adjusting Instrument");
	}
}

class Wind extends Instrument {
	void play(Note n) {
		System.out.println("Wind.play() " + n);
	}

	public String toString() {
		return "Wind";
	}

	void adjust() {
		System.out.println("Adjusting Wind");
	}
}

class Percussion extends Instrument {
	void play(Note n) {
		System.out.println("Percussion.play() " + n);
	}

	public String toString() {
		return "Percussion";
	}

	void adjust() {
		System.out.println("Adjusting Percussion");
	}
}

class Stringed extends Instrument {
	void play(Note n) {
		System.out.println("Stringed.play() " + n);
	}

	public String toString() {
		return "Stringed";
	}

	void adjust() {
		System.out.println("Adjusting Stringed");
	}
}

class Brass extends Wind {
	void play(Note n) {
		System.out.println("Brass.play() " + n);
	}

	void adjust() {
		System.out.println("Adjusting Brass");
	}

	public String toString() {
		return "Brass";
	}
}

class Woodwind extends Wind {
	void play(Note n) {
		System.out.println("Woodwind.play() " + n);
	}

	public String toString() {
		return "Woodwind";
	}
}

class Music3 {
	// Doesn't care about type, so new types
	// added to the system still work right:
	public static void tune(Instrument i) {
		// ...
		i.play(Note.MIDDLE_C);
	}

	public static void tuneAll(Instrument[] e) {
		for (Instrument i : e)
			tune(i);
	}

	public static void printAll(Instrument[] e) {
		for (Instrument i : e)
			System.out.println(i);
	}
}

public class Ex6 {
	public static void main(String[] args) {
		// Upcasting during addition to the array:
		Music3 m3 = new Music3();
		Instrument[] orchestra = { new Wind(), new Percussion(),
				new Stringed(), new Brass(), new Woodwind() };
		m3.printAll(orchestra);
	}
}

/**
 * Output: Wind Percussion Stringed Brass Woodwind
 */
