
package net.minixalpha.chap10;

interface Ex9Inter {
	void foo();
}


public class Ex9 {
	
	public static void bar() {
		class InMethodClass implements Ex9Inter {
			public void foo() {
				System.out.println("I'm foo");
			}
		}
		
		InMethodClass inMethodClass = new InMethodClass();
		inMethodClass.foo();
	}

	public static void main(String[] args) {
		bar();
	}

}
