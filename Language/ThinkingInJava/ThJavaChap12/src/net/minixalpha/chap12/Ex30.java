package net.minixalpha.chap12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

class Annoyance extends RuntimeException {
}

class Sneeze extends Annoyance {
}

public class Ex30 {

	static void foo(int i) {
		try {
			switch (i) {
			case 0:
				throw new Sneeze();
			case 1:
				throw new Annoyance();
			default:
				return;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		try {
			foo(random.nextInt(2));
		} catch (RuntimeException f) {
			try {
				throw f.getCause();
			} catch (Sneeze s) {
				System.out.println("Caught Sneeze");
			} catch (Annoyance a) {
				System.out.println("Caught Annoyance");
			} catch (Throwable g) {
				System.out.println("Throwable " + g);
			}
		}

	}

}
