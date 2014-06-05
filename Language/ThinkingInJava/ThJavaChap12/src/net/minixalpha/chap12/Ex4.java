package net.minixalpha.chap12;

class MyExceptionEx4 extends Exception {
	private String msg;

	public MyExceptionEx4(String msg) {
		super(msg);
		this.msg = msg;
	}

	public void displayMsg() {
		System.out.println(msg);
	}
}

public class Ex4 {

	public static void main(String[] args) {
		try {
			throw new MyExceptionEx4("hijack");
		} catch (MyExceptionEx4 ex4) {
			ex4.printStackTrace();
			ex4.displayMsg();
		}
	}

}
