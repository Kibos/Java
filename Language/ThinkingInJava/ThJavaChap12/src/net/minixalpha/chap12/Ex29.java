package net.minixalpha.chap12;

class BaseballException29 extends RuntimeException {
}

class Foul29 extends BaseballException29 {
}

class Strike29 extends BaseballException29 {
}

abstract class Inning29 {
	public Inning29() throws BaseballException29 {
	}

	public void event() throws BaseballException29 {
		// Doesn't actually have to throw anything
	}

	public abstract void atBat() throws Strike29, Foul29;

	public void walk() {
	} // Throws no checked exceptions
}

class Storm29Exception extends RuntimeException {
}

class RainedOut29 extends Storm29Exception {
}

class PopFoul29 extends Foul29 {
}

interface Storm29 {
	public void event() throws RainedOut29;

	public void rainHard() throws RainedOut29;
}

class Storm29yInning29 extends Inning29 implements Storm29 {
	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:
	public Storm29yInning29() throws RainedOut29, BaseballException29 {
	}

	public Storm29yInning29(String s) throws Foul29, BaseballException29 {
	}

	// Regular methods must conform to base class:
	// ! void walk() throws PopFoul29 {} //Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	// ! public void event() throws RainedOut29 {}
	// If the method doesn't already exist in the
	// base class, the exception is OK:
	public void rainHard() throws RainedOut29 {
	}

	// You can choose to not throw any exceptions,
	// even if the base version does:
	public void event() {
	}

	// Overridden methods can throw inherited exceptions:
	public void atBat() throws PopFoul29 {
	}

}

public class Ex29 {
	public static void main(String[] args) {
		// try {
		Storm29yInning29 si = new Storm29yInning29();
		si.atBat();
		// } catch (PopFoul29 e) {
		// System.out.println("Pop Foul29");
		// } catch (RainedOut29 e) {
		// System.out.println("Rained out");
		// } catch (BaseballException29 e) {
		// System.out.println("Generic baseball exception");
		// }
		// Strike29 not thrown in derived version.
		// try {
		// What happens if you upcast?
		Inning29 i = new Storm29yInning29();
		i.atBat();
		// You must catch the exceptions from the
		// base-class version of the method:
		// } catch (Strike29 e) {
		// System.out.println("Strike29");
		// } catch (Foul29 e) {
		// System.out.println("Foul29");
		// } catch (RainedOut29 e) {
		// System.out.println("Rained out");
		// } catch (BaseballException29 e) {
		// System.out.println("Generic baseball exception");
		// }
	}
}
