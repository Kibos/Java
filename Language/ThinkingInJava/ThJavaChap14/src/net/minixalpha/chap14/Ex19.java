package net.minixalpha.chap14;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Ex19 {

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Class c = Class.forName("net.minixalpha.chap14.Toy");
		Class parameterTypes = int.class;
		Constructor[] cs = c.getConstructors();
		System.out.println(cs.length); // cannot get Toy's constructors
		
//		Constructor cs = c.getConstructor(parameterTypes);
		// Toy t = (Toy) cs.newInstance(3);

		// Toy t = new Toy(3);
	}

}
