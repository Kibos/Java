package net.minixalpha.chap14;

abstract class Instrument {
	public void prepareInstrument() {
	}
}

class Wind extends Instrument {
	public void prepareInstrument() {
		System.out.println("clear split valve");
	}
}

class Percussion extends Instrument {

}

public class Ex26 {

}
