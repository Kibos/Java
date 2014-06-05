package net.minixalpha.chap14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class Ex25Demo {
	private void foo() {
		System.out.println("private");
	}

	protected void bar() {
		System.out.println("protecte");
	}

	void gae() {
		System.out.println("package");
	}
}

public class Ex25 {
	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Ex25Demo demo = new Ex25Demo();
		List<String> methodNames = (Arrays.asList("foo", "bar", "gae"));
		for (String name : methodNames) {
			Method method = Ex25Demo.class.getDeclaredMethod(name);
			method.setAccessible(true);
			method.invoke(demo);
		}
	}
}
