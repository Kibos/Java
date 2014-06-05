/**
 * @author minix
 * @Date Apr 11, 2013 8:10:03 PM
 * @Description
 *		Exercise 20: (1) Create a main( ) that uses varargs instead of the ordinary main( )
 *		syntax. Print all the elements in the resulting args array. Test it with various numbers of
 *		command-line arguments.

 */

package net.minixalpha.chap5;

public class Ex20 {

	/**
	 * @param args
	 */
	public static void main(String ... args) {
		for (String arg: args) {
			System.out.print(arg + " ");
		}
	}
}

/**
Output:(command argu = "a b c")
a b c
Output:(command argu = "a b c d e f g ")
a b c d e f g 
*/