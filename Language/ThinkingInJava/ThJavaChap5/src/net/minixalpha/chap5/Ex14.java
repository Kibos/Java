/**
 * @author minix
 * @Date Apr 8, 2013 10:25:40 PM
 * @Description
 *		Exercise 14: (1) Create a class with a static String field that is initialized at the point of
 *		definition, and another one that is initialized by the static block. Add a static method that
 *		prints both fields and demonstrates that they are both initialized before they are used.
 */

package net.minixalpha.chap5;

class TestInit {
	static String nonBlockStaticVar = "nonBlockStaticVar";
	static String staticBlockVar;
	static {
		staticBlockVar = "statiBlockVar";
	}
	
	static void printStaticVar() {
		System.out.println(nonBlockStaticVar);
		System.out.println(staticBlockVar);
	}
	
}
public class Ex14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestInit.printStaticVar();
	}
}

/*
Output:
nonBlockStaticVar
statiBlockVar
*/