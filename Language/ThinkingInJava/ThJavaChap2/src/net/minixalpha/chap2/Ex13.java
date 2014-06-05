/**
 * Exercise 13: (1) Run Documentation1.java, Documentation2.java, and
 * Documentation3.java through Javadoc. Verify the resulting documentation with your
 * Web browser.
 */
package net.minixalpha.chap2;

/**
 * @author minix
 * <pre>
 * This class's member is:
 * </pre>
 * <ol>
 * <li> filed:i
 * <li> methods:f()
 * </ol>
 */
public class Ex13 {
	/** A field commment */
	public int i;
	
	/** A method comment */
	public void f() {}

}

/*
usage:
$ javadoc Ex12.java Ex13.java
This will put doc of ex12 and ex13 together 
*/