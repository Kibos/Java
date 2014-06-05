//: typeinfo/SimpleProxyDemo.java
package net.minixalpha.chap14;

import static net.mindview.util.Print.*;

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {
		print("doSomething");
	}

	public void somethingElse(String arg) {
		print("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	static int doSimethingTimes;
	static int somethingElse;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	public void doSomething() {
		print("SimpleProxy doSomething");
		proxied.doSomething();
		this.doSimethingTimes++;
	}

	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
		this.somethingElse++;
	}
}

class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
		consumer(new SimpleProxy(new RealObject()));

		System.out.println(SimpleProxy.doSimethingTimes);
		System.out.println(SimpleProxy.somethingElse);
	}
} /*
 * Output: doSomething somethingElse bonobo SimpleProxy doSomething doSomething
 * SimpleProxy somethingElse bonobo somethingElse bonobo
 */// :~
