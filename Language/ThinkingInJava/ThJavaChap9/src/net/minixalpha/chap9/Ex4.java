package net.minixalpha.chap9;

abstract class NoMethods {
	public abstract void say();
}

class SonOfNoMethods extends NoMethods {
	public void say() {
		System.out.println("hi~");
	}
}

public class Ex4 {
	
	public static void speak(NoMethods noMethods) {
//		SonOfNoMethods sonOfNoMethods = (SonOfNoMethods)noMethods;
//		sonOfNoMethods.say();
		noMethods.say();
	}

	public static void main(String[] args) {
		speak(new SonOfNoMethods());
	}

}
