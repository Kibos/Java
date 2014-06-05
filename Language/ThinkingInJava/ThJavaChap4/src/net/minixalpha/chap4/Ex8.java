/**
 * @author minix
 * @date Apr 2, 2013 3:42:32 PM
 * @Description:
 *     Exercise 8: (2) Create a switch statement that prints a message for each case, and put
 *	   the switch inside a for loop that tries each case. Put a break after each case and test it,
 *	   then remove the breaks and see what happens
 */

package net.minixalpha.chap4;

/**
 * 
 */
public class Ex8 {

	/**
	 * @param args
	 */
	static void hasBreakSwitch() {
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				System.out.println(i);
				break;
			case 1:
				System.out.println(i);
				break;
			case 2:
				System.out.println(i);
				break;
			default:
				System.err.println("erro");
			}
		}
	}
	
	static void hasNoBreakSwitch() {
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				System.out.println(i);
			case 1:
				System.out.println(i);
			case 2:
				System.out.println(i);
			default:
				System.err.println("error");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Have Break in each case");
		hasBreakSwitch();
		
		System.out.println("Do not have break in each case");
		hasNoBreakSwitch();
	}
}
/**
Output:
erro
erro
erro
Have Break in each case
0
1
2
Do not have break in each case
0
0
0
1
1
2
*/
