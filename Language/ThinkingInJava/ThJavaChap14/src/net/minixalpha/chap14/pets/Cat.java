//: typeinfo/pets/Cat.java
package net.minixalpha.chap14.pets;



public class Cat extends Pet {
  public Cat(String name) { super(name); }
  public Cat() { super(); }
  
	public static class Factory implements typeinfo.factory.Factory<Class> {
		public Class<? extends Pet> create() {
			return Cat.class;
		}
	}
  
} ///:~
