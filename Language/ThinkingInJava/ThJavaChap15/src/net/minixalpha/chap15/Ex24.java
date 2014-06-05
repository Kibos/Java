package net.minixalpha.chap15;

import java.util.HashMap;
import java.util.Map;

class ClassTypeCapture24<T> {
	Class<T> kind;
	Map<String, Class<?>> typesMap;

	public ClassTypeCapture24(Class<T> kind) {
		this.kind = kind;
		this.typesMap = new HashMap<String, Class<?>>();
	}

	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}

	public void addType(String typeName, Class<?> kind) {
		typesMap.put(typeName, kind);
	}

	public Object create(String typeName) throws InstantiationException,
			IllegalAccessException {
		Class<?> c = typesMap.get(typeName);
		if (c != null) {
			return c.newInstance();
		} else {
			System.err.println("Can not instance");
			return null;
		}
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {
		ClassTypeCapture24<Building> ctt1 = new ClassTypeCapture24<Building>(
				Building.class);
		ctt1.addType("Building", Building.class);
		Building building = (Building) ctt1.create("Building");
		System.out.println("--");
		Building building2 = (Building) ctt1.create("Building2");

	}
}

public class Ex24 {

	public static void main(String[] args) {
		// TODO: cannot understand meaning of the problem, doesn't exercise 21
		// use a map to hold factory objects?
	}

}
