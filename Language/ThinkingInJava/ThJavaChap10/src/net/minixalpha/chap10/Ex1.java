
package net.minixalpha.chap10;

class Outer {
	class Inner {
		public Inner() {
			System.out.println("Init inner");
		}
	}
	
	public Inner getInner() {
		return new Inner();
	}
}

public class Ex1 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.getInner();
	}

}
