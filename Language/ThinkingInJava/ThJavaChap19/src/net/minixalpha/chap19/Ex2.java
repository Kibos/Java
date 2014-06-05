package net.minixalpha.chap19;

import java.util.*;
import net.mindview.util.*;

enum CartoonCharacter {
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
	private static Random rand = new Random(47);

	public static CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
}

class EnumImplementation {
	public static void main(String[] args) {
		// Choose any instance:
		for (int i = 0; i < 10; i++) {
			System.out.println(CartoonCharacter.next());
		}
	}
}

public class Ex2 {
	public static void main(String[] args) {
		EnumImplementation.main(null);
	}
}
