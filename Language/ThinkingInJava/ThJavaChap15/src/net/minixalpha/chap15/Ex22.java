package net.minixalpha.chap15;

import java.lang.reflect.InvocationTargetException;

class Ex22Foo {
	int i;

	public Ex22Foo(int i) {
		this.i = i;
		System.out.println("hijack");
	}
}

public class Ex22 {
	static Object foo(Class<?> c) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		return c.getConstructor(int.class).newInstance(0);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		foo(Ex22Foo.class);
	}
}
