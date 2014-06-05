package net.minixalpha.chap15;

class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;

	public BasicGenerator(Class<T> type) {
		this.type = type;
	}

	public T next() {
		try {
			// Assumes type is a public class:
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Produce a Default generator given a type token:
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}
}

public class Ex14 {

	public static void main(String[] args) {
		// MUST give a type has public access right
		BasicGenerator<Ex14> gen = new BasicGenerator<Ex14>(Ex14.class);
		System.out.println(gen.next());
 	}

}
