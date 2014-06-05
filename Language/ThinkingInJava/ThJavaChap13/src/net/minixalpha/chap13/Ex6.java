
package net.minixalpha.chap13;

class StringFormatDemoEx6 {
	int a = 1;
	float b = 2.3f;
	long c = 4;
	double d = 5.2;
	
	public String toString() {
		return String.format("a:%d, b:%f, c:%d, d:%f", a, b, c, d);
	}
}

public class Ex6 {

	public static void main(String[] args) {
		System.out.println(new StringFormatDemoEx6());
	}

}
