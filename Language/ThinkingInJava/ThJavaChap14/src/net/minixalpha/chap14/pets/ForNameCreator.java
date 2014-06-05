//: net.minixalpha.chap14/pets/ForNameCreator.java
package net.minixalpha.chap14.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "net.minixalpha.chap14.pets.Mutt",
    "net.minixalpha.chap14.pets.Pug",
    "net.minixalpha.chap14.pets.EgyptianMau",
    "net.minixalpha.chap14.pets.Manx",
    "net.minixalpha.chap14.pets.Cymric",
    "net.minixalpha.chap14.pets.Rat",
    "net.minixalpha.chap14.pets.Mouse",
    "net.minixalpha.chap14.pets.Hamster",
    "net.minixalpha.chap14.pets.Gerbil"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
  
  public static void main(String[] args) {
	ForNameCreator fnc = new ForNameCreator();
}
} ///:~
