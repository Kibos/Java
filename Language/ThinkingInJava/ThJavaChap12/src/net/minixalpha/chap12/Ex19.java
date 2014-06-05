package net.minixalpha.chap12;

class VeryImportantException2 extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException2 extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

class LostMessage2 {
	void f() throws VeryImportantException2 {
		throw new VeryImportantException2();
	}

	void dispose() throws HoHumException2 {
		throw new HoHumException2();
	}

}

public class Ex19 {
	public static void main(String[] args) {
		try {
			LostMessage2 lm = new LostMessage2();
			try {
				lm.f();
			} catch (VeryImportantException2 e) {
				throw e;
			} finally {
				// lm.dispose();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
