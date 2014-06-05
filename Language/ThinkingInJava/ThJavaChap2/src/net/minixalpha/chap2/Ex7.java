/**
 *  Exercise 7: (1) Turn the Incrementable code fragments into a working program
 */
package net.minixalpha.chap2;

/**
 * @author minix
 *
 */
class StaticTest {
	static int i;
}
public class Ex7 {
	static void increment() {
		StaticTest.i++;
	}
	public int getStaticTestI() {
		return StaticTest.i;
	}
}
