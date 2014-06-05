/**
 * Exercise 9: (1) Display the largest and smallest numbers for both float and double
 * exponential notation.
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */
public class Ex9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int feMaxNum = Float.MAX_EXPONENT;
		int deMaxNum = Double.MAX_EXPONENT;
		
		System.out.println("Max float exponent is :" + feMaxNum);
		System.out.println("Max double exponet is : " + deMaxNum);
	}

}


/**
 * Max float exponent is :127
 * Max double exponet is : 1023
 */

