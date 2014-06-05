/**
 * @author minix
 * @Date Apr 10, 2013 12:26:43 PM
 * @Description
 *		Exercise 16: (1) Create an array of String objects and assign a String to each element.
 *		Print the array by using a for loop.
 */

package net.minixalpha.chap5;

public class Ex16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strArray = {"apple", "linux", "unix"};
		
		for(int i=0; i<strArray.length; i++) {
			System.out.print(strArray[i] + " ");
		}
	}
}
/**
Output:
apple linux unix 
*/