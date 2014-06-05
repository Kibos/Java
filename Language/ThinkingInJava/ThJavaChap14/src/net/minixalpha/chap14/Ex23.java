package net.minixalpha.chap14;

public class Ex23 {
	// See net.minixalpha.chap14.DynamicProxyHandler
	// StackOverflowError
	
	/**
	 * Print proxy will make the proxy invoke its `toString` method,
	 * that will invoke the `invoke` methods again, thus making an
	 * infinite invoking, until StackOverflow
	 */
}
