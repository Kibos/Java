package net.minixalpha.chap10;

class Outer5 {
	class Inner5 {
		
	}
}

public class Ex5 {
	public static void main(String[] args) {
		Outer5 outer5 = new Outer5();
		Outer5.Inner5 innter5 = outer5.new Inner5();
	}
}
