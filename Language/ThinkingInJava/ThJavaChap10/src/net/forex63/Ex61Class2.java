package net.forex63;

import net.forex61.Ex61Inter1;
import net.forex62.Ex61Class1;

public class Ex61Class2 extends Ex61Class1{
	public Ex61Inter1 bar() {
		return new FooClass();
	}
	
	public static void main(String[] args) {
		Ex61Class2 ex61Class2 = new Ex61Class2();
		ex61Class2.bar();
	}
}
