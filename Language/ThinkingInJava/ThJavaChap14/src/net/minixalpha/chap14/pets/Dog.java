//: typeinfo/pets/Dog.java
package net.minixalpha.chap14.pets;

public class Dog extends Pet {
  public Dog(String name) { super(name); }
  public Dog() { super(); }
  
  public static class Factory implements typeinfo.factory.Factory<Class> {
		public Class<? extends Pet> create() {
			return Dog.class;
		}
	}

} ///:~
