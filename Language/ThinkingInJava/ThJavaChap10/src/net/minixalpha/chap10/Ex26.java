
package net.minixalpha.chap10;

import net.minixalpha.chap10.Ex26Foo.InEx26Foo;

class Ex26Foo {
	class InEx26Foo {
		int i = 0;
		public InEx26Foo(int i) {
			this.i = i;
		}
	}
}


public class Ex26 {
	
	class Ex26Bar extends InEx26Foo {
		public Ex26Bar(Ex26Foo ex26Foo, int i) {
			ex26Foo.super(i);
		}

	}

	public static void main(String[] args) {

	}

}
