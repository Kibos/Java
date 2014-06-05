/**
 * Exercise 2: (1) Create a class containing a float and use it to demonstrate aliasing.
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */

class FloatClass {
	 float floatFiled;
}
public class Ex2 {

	/**
	 * Point:
	 * Whenever you manipulate an object, what
	 * you’re manipulating is the reference, so when you assign 
	 * “from one object to another,” you’re actually copying a 
	 * reference from one place to another. 
	 * @param args
	 */
	private static void printResult(float fc1Field, float fc2Field) {
		System.out.println("fc1's loatFiled: " + fc1Field + "," + 
				"fc2's floatFiled: " + fc2Field);
	}
	public static void main(String[] args) {
		FloatClass fc1 = new FloatClass();
		FloatClass fc2 = new FloatClass();
		fc1.floatFiled = 3.6F;
		fc2.floatFiled = 7.3F;
		printResult(fc1.floatFiled, fc2.floatFiled);
		
		fc1 = fc2;
		printResult(fc1.floatFiled, fc2.floatFiled);
		
		fc1.floatFiled = 1.9F;
		printResult(fc1.floatFiled, fc2.floatFiled);
		
	}

}

/**
 * Output:
 * fc1's loatFiled: 3.6,fc2's floatFiled: 7.3
 * fc1's loatFiled: 7.3,fc2's floatFiled: 7.3
 * fc1's loatFiled: 1.9,fc2's floatFiled: 1.9
*/
