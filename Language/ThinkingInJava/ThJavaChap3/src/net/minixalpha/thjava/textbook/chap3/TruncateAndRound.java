/**
 * 
 */
package net.minixalpha.thjava.textbook.chap3;

/**
 * @author minix
 *
 */
public class TruncateAndRound {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float below = 0.3f;
		float above = 0.6f;
		System.out.println("Trancation: ");
		System.out.println("(int)"+below+":" + (int)below);
		System.out.println("(int)"+above+":" + (int)above);
		
		System.out.println("Round");
		System.out.println("Math.round("+below+"):" + Math.round(below));
		System.out.println("Math.round("+above+"):" + Math.round(above));
		
	}

}
/**
Output:
Trancation: 
(int)0.3:0
(int)0.6:0
Round
Math.round(0.3):0
Math.round(0.6):1
*/