//: typeinfo/SimpleDynamicProxy.java

package net.minixalpha.chap14;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	Map<Method, Integer> invokeTimes = new HashMap<Method, Integer>();
	
	
	
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	private void addRecords(Method method) {
		Integer value = invokeTimes.get(method);
		value = (value == null) ? 1 : (value + 1);
		invokeTimes.put(method, value);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("**** proxy: " + proxy.getClass() + ", method: "
				+ method + ", args: " + args);
		if (args != null)
			for (Object arg : args)
				System.out.println("  " + arg);
		addRecords(method);
//		System.out.println(proxy);
		return method.invoke(proxied, args);
	}
	
	public void printRecord() {
		System.out.println(invokeTimes);
	}
}

class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		// Insert a proxy and call again:
		
		DynamicProxyHandler dHandler = new DynamicProxyHandler(real);
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] { Interface.class }, dHandler);
		consumer(proxy);
		consumer(proxy);
		dHandler.printRecord();
	}
} /*
 * Output: (95% match) doSomething somethingElse bonobo*** proxy: class $Proxy0,
 * method: public abstract void Interface.doSomething(), args: null doSomething
 * *** proxy: class $Proxy0, method: public abstract void
 * Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
 * bonobo somethingElse bonobo
 */// :~
