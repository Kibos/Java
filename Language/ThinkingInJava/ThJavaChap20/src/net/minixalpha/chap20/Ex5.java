package net.minixalpha.chap20;

import java.util.HashSet;

import net.mindview.atunit.AtUnit;
import net.mindview.atunit.Test;

public class Ex5 extends HashSet<String> {
	HashSet<String> testObject = new HashSet<String>();

	// assert DOES NOT work 
	// it can NOT make a failure test
	
	@Test
	void _isEmpty() {
		assert testObject.isEmpty();
	}

	@Test
	void _contains() {
		testObject.add("one");
		assert testObject.contains("one");
	}

	@Test
	void _remove() {
		testObject.add("one");
		testObject.remove("one");
		assert testObject.isEmpty();
	}
	
	@Test
	boolean _testTest() {
		return false;
	}

	public static void main(String[] args) throws Exception {
		// OSExecute.command("java net.mindview.atunit.AtUnit HashSetTest");
		AtUnit unit = new AtUnit();
		String[] margs = { new String("bin/net/minixalpha/chap20/Ex5") };
		unit.main(margs);
	}
}
