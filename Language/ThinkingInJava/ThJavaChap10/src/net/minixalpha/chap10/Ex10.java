package net.minixalpha.chap10;

interface Ex10Inter {
	void foo();
}

public class Ex10 {

	public static void bar(int i) {
		Ex10Inter ex10Inter;

		if (i == 1) {
			class InMethodClass implements Ex10Inter {
				public void foo() {
					System.out.println("I'm foo");
				}
			}

			ex10Inter = new InMethodClass();
		} else {
			class InMethodClass2 implements Ex10Inter {
				public void foo() {
					System.out.println("I'm foo2");
				}
			}

			ex10Inter = new InMethodClass2();
		}
		ex10Inter.foo();
	}

	public static void main(String[] args) {
		bar(0);
		bar(1);
	}

}
