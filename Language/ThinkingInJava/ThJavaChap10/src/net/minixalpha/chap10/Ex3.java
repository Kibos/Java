
package net.minixalpha.chap10;


class Outer3 {
	private String fooString;
	
	public Outer3(String fooString) {
		this.fooString = fooString;
	}
	
	class Inner3 {
		public Inner3() {
		}
		
		public String toString() {
			return fooString;
		}
	}
	
	public Inner3 getInner() {
		return new Inner3();
	}
}

public class Ex3 {

	public static void main(String[] args) {
		Outer3 outer = new Outer3("xyz");
		Outer3.Inner3 inner = outer.getInner();
		System.out.println(inner.toString());
	}

}
