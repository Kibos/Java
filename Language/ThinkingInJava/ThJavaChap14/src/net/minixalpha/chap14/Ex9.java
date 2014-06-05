package net.minixalpha.chap14;

import java.lang.reflect.Field;

class FooEx9 {
	int a;
	float b;

	public void foo() {
	}

}

public class Ex9 {
	public static void main(String[] args) {
		FooEx9 fooEx9 = new FooEx9();
		
		Class c9 = fooEx9.getClass();
		Field[] fields = c9.getDeclaredFields();
		for (Field f: fields) {
			System.out.println(f.getName());
		}
	}
}
