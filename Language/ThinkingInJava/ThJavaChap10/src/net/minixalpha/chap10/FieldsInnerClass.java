
package net.minixalpha.chap10;

public class FieldsInnerClass {
	void foo() {
		class InFoo {
			void bar() {
				System.out.println("bar");
			}
		}
		
		InFoo inFoo = new InFoo();
		inFoo.bar();
	}
	
	void bar() {
		if (true) {
			class InBar {
				void foo() {
					System.out.println("foo");
				}
			}
			InBar inBar = new InBar();
			inBar.foo();
		}
		
//		InBar inBar = new InBar();
	}

}
