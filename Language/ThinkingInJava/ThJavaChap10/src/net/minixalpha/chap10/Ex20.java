
package net.minixalpha.chap10;

import net.minixalpha.chap10.Ex20Interface.InInterfaceClass;

interface Ex20Interface {
	static class InInterfaceClass {
		public void foo() {
			System.out.println("~~");
		}
	}
}

class TestInterface implements Ex20Interface {
	
}

public class Ex20 {
	public static void main(String[] args) {
		InInterfaceClass x = new InInterfaceClass();
		x.foo();
	}

}
