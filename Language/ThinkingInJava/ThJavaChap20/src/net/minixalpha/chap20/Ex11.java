package net.minixalpha.chap20;

import net.mindview.atunit.AtUnit;
import net.mindview.atunit.Test;
import net.mindview.atunit.TestNote;

public class Ex11 extends Multiplier {
	// See net.mindview.atunit/[AtUnit.java | TestNote.java]

	@Test
	@TestNote("hijack")
	boolean _multiplay() {
		return multiply(2, 3) == 6;
	}

	@Test
	boolean _multiplayNeg() {
		return multiply(2, 3) == 4;
	}

	public static void main(String[] args) {
		AtUnit unit = new AtUnit();
		String[] margs = { new String("bin/net/minixalpha/chap20/Ex11") };
		try {
			unit.main(margs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
