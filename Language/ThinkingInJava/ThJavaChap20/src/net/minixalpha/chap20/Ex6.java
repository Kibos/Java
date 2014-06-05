package net.minixalpha.chap20;

import java.util.HashSet;
import java.util.LinkedList;

import net.mindview.atunit.AtUnit;
import net.mindview.atunit.Test;

public class Ex6 {
	LinkedList<String> testObject = new LinkedList<>();

	@Test
	void initialization() {
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

	public static void main(String[] args) throws Exception {
		// OSExecute.command("java net.mindview.atunit.AtUnit HashSetTest");
		AtUnit unit = new AtUnit();
		String[] margs = { new String("bin/net/minixalpha/chap20/Ex6") };
		unit.main(margs);
	}
}
