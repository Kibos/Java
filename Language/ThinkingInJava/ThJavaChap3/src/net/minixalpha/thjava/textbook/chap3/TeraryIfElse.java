/**
 * Terary: (a>b)?c:d
 */
package net.minixalpha.thjava.textbook.chap3;

/**
 * @author minix
 *
 */
public class TeraryIfElse {

	/**
	 * @param args
	 */
	static int terary(int i) {
		return i < 10 ? i*4 : i*10;
	}
	
	static int standardIfElse(int i) {
		if (i < 10) {
			return i * 4;
		} else {
			return i * 10;
		}
	}
	public static void main(String[] args) {
		System.out.println(terary(9));
		System.out.println(terary(10));
		
		System.out.println(standardIfElse(9));
		System.out.println(standardIfElse(10));
	}
}

/**
Output:
36
100
36
100
 */
