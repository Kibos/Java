
package net.minixalpha.chap10;

class Ex7Foo {
	private int i = 0;
	
	private void foo() {
		System.out.println("Ex7Foo.foo");
	}
	
	public int getI() {
		return i;
	}
	
	public void bar() {
		Ex7Inner ex7Inner = new Ex7Inner();
		ex7Inner.bar();
	}
	
	class Ex7Inner {
		public void bar() {
			i = 1;
			foo();
		}
	}
}
public class Ex7 {

	public static void main(String[] args) {
		Ex7Foo ex7Foo = new Ex7Foo();
		System.out.println(ex7Foo.getI());
		ex7Foo.bar();
		System.out.println(ex7Foo.getI());
	}

}
