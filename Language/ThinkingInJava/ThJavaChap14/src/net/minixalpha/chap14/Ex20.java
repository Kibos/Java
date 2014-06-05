package net.minixalpha.chap14;

public class Ex20 {

	static void foo(Class c) {
		System.out.println(c.getCanonicalName());
		System.out.println(c.getModifiers());
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		System.out.println(c.getAnnotations());
		System.out.println(c.getClass());
		System.out.println(c.getClasses());
		System.out.println(c.getClassLoader());
		System.out.println(c.getComponentType());
		System.out.println(c.getConstructors());
		System.out.println(c.getDeclaredAnnotations());
		System.out.println(c.getDeclaredMethods());
		System.out.println(c.getFields());
		System.out.println(c.getTypeParameters());
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("net.minixalpha.chap14.Ex19");
		foo(c);
		
		System.out.println("--");
		
		Class c2 = Class.forName("java.lang.Class");
		foo(c2);
	}
}
