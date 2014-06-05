package net.minixalpha.chap14;

import java.util.ArrayList;

class FooEx8 {
	
}

class BarEx8 extends FooEx8 {
	
}

public class Ex8 {
	
	static void printHerachy(Object c) throws InstantiationException, IllegalAccessException {
		Class cc = c.getClass();
		String ccSimpleName = cc.getSimpleName();
		if (ccSimpleName.equals("Object")) {
			System.out.println("Object");
		} else {
			System.out.println(ccSimpleName);
			printHerachy(cc.getSuperclass().newInstance());
		}
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		printHerachy(new BarEx8());
	}
}
