package net.minixalpha.chap20;

import java.util.HashMap;

import net.mindview.atunit.AtUnit;
import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCreate;

public class Ex9 extends HashMap<String, Integer> {
	@TestObjectCreate
	static Ex9 create() {
		return new Ex9();
	}

	@Test
	boolean _isEmpty() {
		return isEmpty();
	}
	
	@Test
	boolean _put() {
		put("abc", 3);
		return get("abc").equals(3);
	}

	public static void main(String[] args) throws Exception {
		AtUnit unit = new AtUnit();
		String[] margs = { new String("bin/net/minixalpha/chap20/Ex9") };
		unit.main(margs);
	}
}
