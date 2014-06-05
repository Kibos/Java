package net.minixalpha.chap9;

abstract class CallPrint {
	private int i;
	
	public CallPrint() {
		print();
	}
	
	public abstract void print();
}

class SonOfCallPrint extends CallPrint {
	private int i = -1;
	
	public void print() {
		System.out.println(i);
	}
}

public class Ex3 {
	public static void main(String[] args) {
		SonOfCallPrint sonOfCallPrint = new SonOfCallPrint();
		sonOfCallPrint.print();
	}
}

/*
 * When invoke constructor, private variable is not initialized.
*/