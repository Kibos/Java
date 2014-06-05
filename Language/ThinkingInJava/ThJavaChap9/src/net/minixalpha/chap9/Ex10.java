package net.minixalpha.chap9;

interface InstrumentEx10 {
	// Compile-time constant:
	int VALUE = 5; // static & final

	// Cannot have method definitions:

}

interface Playable {
	void play(int n); // Automatically public
}

class WindEx10 implements Playable, InstrumentEx10 {
	public void play(int n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Wind";
	}

}

class PercussionEx10 implements Playable, InstrumentEx10 {
	public void play(int n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Percussion";
	}

}

class StringedEx10 implements Playable, InstrumentEx10 {
	public void play(int n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Stringed";
	}

}

class BrassEx10 extends WindEx10 {
	public String toString() {
		return "Brass";
	}
}

class WoodwindEx10 extends WindEx10 {
	public String toString() {
		return "Woodwind";
	}
}

public class Ex10 {
	
	 static void tune(Playable i) {
		    // ...
		    i.play(1);
		  }
		  static void tuneAll(Playable[] e) {
		    for(Playable i : e)
		      tune(i);
		  }	

	public static void main(String[] args) {
		Playable[] playables = {
				new WoodwindEx10(),
				new BrassEx10()
		};
		
		tuneAll(playables);
	}

}
