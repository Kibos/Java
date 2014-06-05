//: generics/coffee/Breve.java
package generics.coffee;
public class Breve extends Coffee {
	
	public static class Factory implements typeinfo.factory.Factory<Breve> {

		@Override
		public Breve create() {
			return new Breve();
		}
		  
	  }
	
} ///:~
