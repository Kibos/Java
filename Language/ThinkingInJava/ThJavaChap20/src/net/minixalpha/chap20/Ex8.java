package net.minixalpha.chap20;

import net.mindview.atunit.AtUnit;
import net.mindview.atunit.Test;
import net.mindview.atunit.TestProperty;

class ToTest {
	private int testPrivateMethod() {
		return 1;
	}

	@TestProperty
	public int TesttestPrivateMethod() {
		return testPrivateMethod();
	}
}

public class Ex8 extends ToTest {

	@Test
	boolean _testPrivateMethod() {
		return TesttestPrivateMethod() == 1;
	}

	public static void main(String[] args) throws Exception {
		AtUnit unit = new AtUnit();
		String[] margs = { new String("bin/net/minixalpha/chap20/Ex8") };
		unit.main(margs);
	}

}
