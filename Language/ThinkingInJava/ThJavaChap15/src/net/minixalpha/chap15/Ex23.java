package net.minixalpha.chap15;

interface FactoryI<T> {
	T create(Object o);
}

class Foo2<T> {
	private T x;

	public <F extends FactoryI<T>> Foo2(F factory, Object o) {
		x = factory.create(o);
	}
	// ...
}

class IntegerFactory implements FactoryI<Integer> {
	public Integer create(Object o) {
		if (o instanceof Integer) {
			return new Integer((Integer) o);
		} else {
			return null;
		}
	}
}

class Widget {
	public Widget(Object a) {
	}

	public static class Factory implements FactoryI<Widget> {
		public Widget create(Object o) {
			return new Widget(o);
		}
	}
}

public class Ex23 {
	public static void main(String[] args) {
		new Foo2<Integer>(new IntegerFactory(), new Integer(2));
		new Foo2<Widget>(new Widget.Factory(), "abc");
	}
}
