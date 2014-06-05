package net.minixalpha.chap15;

import java.util.*;

class Building {
}

class House extends Building {
}

class ClassTypeCapture<T> {
	Class<T> kind;
	Map<String, Class<?>> typesMap;

	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
		this.typesMap = new HashMap<String, Class<?>>();
	}

	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	
	public void addType(String typeName, Class<?> kind) {
		typesMap.put(typeName, kind);
	}
	
	public Object create(String typeName) throws InstantiationException, IllegalAccessException {
		Class<?> c = typesMap.get(typeName);
		if(c != null) {
			return c.newInstance();
		} else {
			System.err.println("Can not instance");
			return null;
		}
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(
				Building.class);
		ctt1.addType("Building", Building.class);
		Building building = (Building)ctt1.create("Building");
		System.out.println("--");
		Building building2 = (Building)ctt1.create("Building2");
		
		
	}
}

public class Ex21 {

	public static void main(String[] args) {

	}

}
