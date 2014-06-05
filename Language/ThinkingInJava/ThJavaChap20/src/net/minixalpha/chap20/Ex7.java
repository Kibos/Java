package net.minixalpha.chap20;

import java.util.HashSet;
import java.util.LinkedList;

import net.mindview.atunit.AtUnit;
import net.mindview.atunit.Test;

public class Ex7 extends HashSet<String> {
	LinkedList<String> testObject = new LinkedList<>();

	// assert DOES NOT work
	// it can NOT make a failure test
	// Solution
	// Run with flag '-ea' ?

	@Test
	void _isEmpty() {
		assert testObject.isEmpty();
	}

	@Test
	boolean _containsNeg() {
		return testObject.contains("one");
	}

	@Test
	boolean _containsPos() {
		testObject.add("one");
		return testObject.contains("one");
	}

	@Test
	void _remove() {
		testObject.add("one");
		testObject.remove("one");
		assert testObject.isEmpty();
	}

	public static void main(String[] args) throws Exception {
		// OSExecute.command("java net.mindview.atunit.AtUnit HashSetTest");
		AtUnit unit = new AtUnit();
		String[] margs = { new String("bin/net/minixalpha/chap20/Ex7") };
		unit.main(margs);
	}
}