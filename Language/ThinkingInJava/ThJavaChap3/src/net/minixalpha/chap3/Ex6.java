/**
 * Exercise 6: (3) Following Exercise 5, create a new Dog reference and assign it to spot’s
 * object. Test for comparison using == and equals( ) for all references.
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */

class BigDog {
	String name;
	String says;
}

public class Ex6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDog dogA = new BigDog();
		dogA.name = "spot";
		dogA.says = "Wurf!";
		
		// This make dogACopy and dogA reference to a same object
		BigDog dogACopy = dogA;
		
		System.out.println("Compare dogA and dogACopy using == :");
		System.out.println("dogA and dogACopy is " + (dogA == dogACopy));
		
		System.out.println("Compare dogA and dogACopy using equals :");
		System.out.println("dogA and dogACopy is " + (dogA.equals(dogACopy)));
	}

}

/**
 * Output:
 * Compare dogA and dogACopy using == :
 * dogA and dogACopy is true
 * Compare dogA and dogACopy using equals :
 * dogA and dogACopy is true
 */
