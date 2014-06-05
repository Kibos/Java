/**
 * @author minix
 * @Date Jun 10, 2013 9:45:15 PM
 * @Description
 *		Create a class with a static final field and a final field and
		demonstrate the difference between the two.
 */
package net.minixalpha.chap7;

class TestStaticFinal {
	static final int[] STATIC_FINAL_VAL = {1};
	final int[] final_var = {3};
	
	public String toString() {
		return STATIC_FINAL_VAL[0] + " " + final_var[0];
	}
}

public class Ex18 {
	public static void main(String[] args) {
		TestStaticFinal testStaticFinal = new TestStaticFinal();
		System.out.println("start:" + testStaticFinal.toString());
		
		testStaticFinal.STATIC_FINAL_VAL[0] = 2;
		testStaticFinal.final_var[0] = 4;
		System.out.println("change:" + testStaticFinal.toString());
		
		TestStaticFinal testStaticFinal2 = new TestStaticFinal();
		System.out.println("new start:" + testStaticFinal2.toString());
		
	}
}

/**
Output:
start:1 3
change:2 4
new start:2 3
*/
