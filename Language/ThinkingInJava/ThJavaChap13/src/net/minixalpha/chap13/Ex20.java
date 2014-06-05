
package net.minixalpha.chap13;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;


class Ex20Foo {
	int x;
	long y;
	float z;
	double k;
	String p;
	
	public Ex20Foo(String inputString) {
		Scanner scanner = new Scanner(new StringReader(inputString));
		x = scanner.nextInt();
		y = scanner.nextLong();
		z = scanner.nextFloat();
		k = scanner.nextDouble();
		p = scanner.next();
	}
	
	public String toString() {
		return x + " " + y + " " + z + " " + k + " " + p;
	}
}


public class Ex20 {

	public static void main(String[] args) {
		Ex20Foo foo = new Ex20Foo("12 132 1.2 2.3 asdf");
		System.out.println(foo);

	}

}
