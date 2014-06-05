/**
 * Exercise 10: (3) Write a program with two constant values, one with alternating binary
 * ones and zeroes, with a zero in the least-significant digit, and the second, also alternating,
 * with a one in the least-significant digit (hint: It’s easiest to use hexadecimal constants for
 * this). Take these two values and combine them in all possible ways using the bitwise
 * operators, and display the results using Integer.toBinaryString( ).
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */
public class Ex10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 0x5555;
		int b = 0xaaaa;
		
		System.out.println( "a is  " + Integer.toBinaryString(a));
		System.out.println( "b is " + Integer.toBinaryString(b));
		
		System.out.println( "a & b is " + Integer.toBinaryString((a & b)));
		System.out.println( "a | b is " + Integer.toBinaryString((a | b)));
		System.out.println( "a ^ b is " + Integer.toBinaryString((a ^ b)));
		System.out.println( "~a is " + Integer.toBinaryString((~a)));
	}

}

/**
 * Output:
a is  101010101010101
b is 1010101010101010
a & b is 0
a | b is 1111111111111111
a ^ b is 1111111111111111
~a is 11111111111111111010101010101010
*/