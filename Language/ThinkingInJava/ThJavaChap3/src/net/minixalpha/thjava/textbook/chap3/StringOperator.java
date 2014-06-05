/**
 * Usint + to concatenate String and int
 */
package net.minixalpha.thjava.textbook.chap3;

/**
 * @author minix
 *
 */
public class StringOperator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x=0, y=1, z=2;
		String s = "x,y,z: ";
		System.out.println(s + x + y + z);
		System.out.println(s + "sumed: " + (x+y+z));
	}

}
/**
Output:
x,y,z: 012
x,y,z: sumed: 3
*/