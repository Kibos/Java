package net.minixalpha.chap12;

class MyExceptionEx28 extends RuntimeException {
	private String msg;

	public MyExceptionEx28(String msg) {
		super(msg);
		this.msg = msg;
	}

	public void displayMsg() {
		System.out.println(msg);
	}
}

public class Ex28 {

	public static void main(String[] args) {
		throw new MyExceptionEx28("hijack");

	}

}
