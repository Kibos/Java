/**
 * @author minix
 * @date Mar 31, 2013 5:21:30 PM
 * @Description:
 *     Exercise 5: (4) Repeat Exercise 10 from the previous chapter, using the ternary operator
 *	   and a bitwise test to display the ones and zeroes, instead of Integer.toBinaryString( ).
 *
 *	   Exercise 10: (3) Write a program with two constant values, one with alternating binary
 * 	   ones and zeroes, with a zero in the least-significant digit, and the second, also alternating,
 * 	   with a one in the least-significant digit (hint: It’s easiest to use hexadecimal constants for
 * 	   this). Take these two values and combine them in all possible ways using the bitwise
 * 	   operators, and display the results using Integer.toBinaryString( ).
 */

package net.minixalpha.chap4;

public class Ex5 {

	/**
	 * @param args
	 */
	static String intInBinary(int a) {
		String result = "";
		int magic = 1;
		for(int i=0; i<32; i++) {
			if ((a & magic) == 0) {
				result = "0" + result;
			} else {
				result = "1" + result;
			}
			magic = magic << 1;
		}
		return result;
	}
	public static void main(String[] args) {
		int a = 0x5555;
		int b = 0xaaaa;
		
		System.out.println(a + " in binary is: " + intInBinary(a));
		System.out.println(b + " in binary is: " + intInBinary(b));
		
		System.out.println( "a & b is " + intInBinary((a & b)));
		System.out.println( "a | b is " + intInBinary((a | b)));
		System.out.println( "a ^ b is " + intInBinary((a ^ b)));
		System.out.println( "~a is " + intInBinary((~a)));
		
	}

}

/**
Output:
21845 in binary is: 00000000000000000101010101010101
43690 in binary is: 00000000000000001010101010101010
a & b is 00000000000000000000000000000000
a | b is 00000000000000001111111111111111
a ^ b is 00000000000000001111111111111111
~a is 11111111111111111010101010101010
*/