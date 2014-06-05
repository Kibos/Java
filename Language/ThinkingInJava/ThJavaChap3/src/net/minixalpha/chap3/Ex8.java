/**
 * Exercise 8: (2) Show that hex and octal notations work with long values. Use
 * Long.toBinaryString( ) to display the results.
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */
public class Ex8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long l1 = 0777l;
		long l2 = 0x123L;
		
		System.out.println("0777L is " + Long.toBinaryString(l1));
		System.out.println("0x123L is " + Long.toBinaryString(l2));
	}

}

/**
 * Output:
 * 0777L is 111111111
 * 0x123L is 100100011
*/
