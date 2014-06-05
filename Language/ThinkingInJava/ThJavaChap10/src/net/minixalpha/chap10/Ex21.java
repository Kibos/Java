
package net.minixalpha.chap10;

import net.minixalpha.chap10.Ex21Interface.InEx21Interface;

interface Ex21Interface {
	void bar();
	
	static class InEx21Interface {
		static void foo(Ex21Interface ex21Interface) {
			ex21Interface.bar();
		}
	}
}

class ImplementEx21Interface implements Ex21Interface {
	public void bar() {
		System.out.println("bar");
	}
}


public class Ex21 {

	public static void main(String[] args) {
		InEx21Interface.foo(new ImplementEx21Interface());
	}

}
