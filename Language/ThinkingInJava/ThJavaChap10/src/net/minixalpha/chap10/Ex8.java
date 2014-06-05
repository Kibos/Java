
package net.minixalpha.chap10;
public class Ex8 {
	
	class Ex8Inner {
		private int bar = 0;
		private int foo() {
			bar = 1;
			return bar;
		}
	}

	public static void main(String[] args) {
//		Ex8Inner.bar = 1;
//		Ex8Inner.foo();
		
		Ex8 ex8 = new Ex8();
		Ex8.Ex8Inner ex8Inner = ex8.new Ex8Inner();
		ex8Inner.bar = 2;
		System.out.println(ex8Inner.foo());
	}

}
