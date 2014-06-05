package net.minixalpha.chap13;

public class Ex7 {

	public static void main(String[] args) {
		String regex = "^[A-Z].+\\.$";
		System.out.println("This is a book.".matches(regex));
		System.out.println("this is a book.".matches(regex));
		System.out.println("This is a book?".matches(regex));
		System.out.println("this is a book?".matches(regex));
	}

}
