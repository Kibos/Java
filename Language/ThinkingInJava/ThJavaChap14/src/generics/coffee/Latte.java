//: generics/coffee/Latte.java
package generics.coffee;

public class Latte extends Coffee {

	public static class Factory implements typeinfo.factory.Factory<Latte> {

		@Override
		public Latte create() {
			return new Latte();
		}

	}

} // /:~
