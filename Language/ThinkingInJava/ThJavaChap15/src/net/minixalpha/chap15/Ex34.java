package net.minixalpha.chap15;

class BarEx34<T> {
}

abstract class FooEx34<T extends BarEx34<T>> {
	abstract T foo(T a);
	
	public T bar(T a) {
		return foo(a);
	}
}

class FooSonEx34 extends FooEx34 {

	@Override
	BarEx34 foo(BarEx34 a) {
		return null;
	}
	
}

public class Ex34 {

	public static void main(String[] args) {
		FooSonEx34 demo = new FooSonEx34();
		demo.bar(new BarEx34());
	}

}
