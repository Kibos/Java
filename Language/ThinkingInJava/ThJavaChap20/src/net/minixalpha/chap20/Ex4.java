package net.minixalpha.chap20;

import java.util.*;
import net.mindview.atunit.*;



public class Ex4 {
	HashSet<String> testObject = new HashSet<String>();

	@Test
	void initialization() {
		System.err.println(testObject.hashCode());
		assert testObject.isEmpty();
	}

	@Test
	void _contains() {
		System.err.println(testObject.hashCode());
		testObject.add("one");
		assert testObject.contains("one");
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
		String[] margs = { new String("bin/net/minixalpha/chap20/Ex4") };
		unit.main(margs);
	}
}
