/**
 * Exercise 8: (3) Write a program that demonstrates that, no matter how many objects
 * you create of a particular class, there is only one instance of a particular static field in that
 * class.
 */
package net.minixalpha.chap2;

/**
 * @author minix
 *
 */
public class Ex8 {
	static int staticI;
	public void increaseStaticI() {
		this.staticI++;
	}
	public int getStaticI() {
		return this.staticI;
	}

}
