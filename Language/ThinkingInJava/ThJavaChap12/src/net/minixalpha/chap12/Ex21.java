package net.minixalpha.chap12;

class Base21 {
	public Base21() {
		throw new NullPointerException();
	}
}

class Son21 extends Base21 {
	public Son21() {
		try {
//			super();
		} catch (NullPointerException e) {
			
		}
	}
}

public class Ex21 {

	public static void main(String[] args) {
		
	}

}
