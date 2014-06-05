package net.minixalpha.chap12;

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

class ThirdException extends Exception {
	public String toString() {
		return "The third exception";
	}
}

class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

}

public class Ex18 {
	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} finally {
				try {
				lm.dispose();
				} finally {
					throw new ThirdException();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
