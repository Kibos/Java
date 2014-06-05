package net.minixalpha.chap9;

abstract class Instrument {
	public abstract void play();
	public void what() {
		System.out.println("Instrucment.what()");
	}
}

class Wind extends Instrument {
	@Override
	public void play() {
		System.out.println("Wind.play()");
	}
}

public class Music4 {
	public static void main(String[] args) {
//	Instrument instrument = new Instrument();
		Wind wind = new Wind();
		wind.play();
		wind.what();
	}
}
