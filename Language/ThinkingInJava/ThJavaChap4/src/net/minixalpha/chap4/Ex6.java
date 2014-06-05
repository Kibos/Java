/**
 * @author minix
 * @date Apr 1, 2013 9:40:12 PM
 * @Description:
 *      Exercise 6: (2) Modify the two test( ) methods in the previous two programs so that
 *	    they take two extra arguments, begin and end, and so that testval is tested to see if it is
 *		within the range between (and including) begin and end.

 */

package net.minixalpha.chap4;

/**
 * 
 */
public class Ex6 {

	/**
	 * @param args
	 */
	static boolean test(int testval, int begin, int end) {
		if (testval >= begin && testval <= end) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(test(2,1,4));
		System.out.println(test(4,1,2));
	}
}

/**
true
false
*/