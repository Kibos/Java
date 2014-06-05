
package net.minixalpha.chap10;



public class Ex18 {
	private static class Ex18StaticInnerClass {
		public void foo() {
		}
	}
	
	public static void main(String[] args) {
		Ex18StaticInnerClass x = new Ex18StaticInnerClass();
		x.foo();
	}

}
