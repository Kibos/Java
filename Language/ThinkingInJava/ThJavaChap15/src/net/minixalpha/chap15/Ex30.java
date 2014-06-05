package net.minixalpha.chap15;

class HolderInt {
	Integer a = new Integer(0);

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getA() {
		return this.a;
	}
}

public class Ex30 {
	public static void main(String[] args) {
		HolderInt holderInt = new HolderInt();
		holderInt.setA(3);
		int b = holderInt.getA();
	}
}
