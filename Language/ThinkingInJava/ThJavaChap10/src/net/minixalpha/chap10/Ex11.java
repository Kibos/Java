package net.minixalpha.chap10;

interface Ex11Inter {
	void foo();
}

public class Ex11 {

	private class Ex11Inner implements Ex11Inter {
		public void foo() {
			System.out.println("foo");
		}
	}

	Ex11Inter getInstance() {
		return new Ex11Inner();
	}

	public static void main(String[] args) {
		Ex11 ex11 = new Ex11();
		Ex11Inter ex11Inter = ex11.getInstance();
		ex11Inter.foo();
		
		Ex11Inner ex11Inner = (Ex11Inner)ex11Inter;
		ex11Inner.foo();
	}

}
