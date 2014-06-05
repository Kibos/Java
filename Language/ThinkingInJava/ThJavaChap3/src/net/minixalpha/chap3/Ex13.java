/**
 * Exercise 13: (1) Write a method that displays char values in binary form. Demonstrate
 * it using several different characters.
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */
public class Ex13 {

	/**
	 * @param args
	 */
	static void displayCharInBin(char c) {
		System.out.println(c + " in binary: " + Integer.toBinaryString(c));
	}
	public static void main(String[] args) {
		displayCharInBin('a');
		displayCharInBin('b');
		displayCharInBin('z');
		
		displayCharInBin('A');
		displayCharInBin('B');
		displayCharInBin('Z');
	}

}

/**
Output:
a in binary: 1100001
b in binary: 1100010
z in binary: 1111010
A in binary: 1000001
B in binary: 1000010
Z in binary: 1011010
*/