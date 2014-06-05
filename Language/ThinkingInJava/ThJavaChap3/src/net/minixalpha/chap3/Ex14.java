/**
 * Exercise 14: (3) Write a method that takes two String arguments and uses all the
 * boolean comparisons to compare the two Strings and print the results. For the == and !=,
 * also perform the equals( ) test. In main( ), call your method with some different String
 * objects.
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */
public class Ex14 {

	/**
	 * @param args
	 */
	
	static void compareString(String a, String b) {
		System.out.println(a + " == " + b +":" + (a==b));
		System.out.println(a + " != " + b +":" + (a!=b));
		System.out.println(a + ".equals(" + b +"):" + a.equals(b));
//		System.out.println(a + ">" + b +":" + (a>b));
//		System.out.println(a + "<=" + b +":" + (a<=b));
//		System.out.println(a + "&&" + b +":" + (a&&b));
//		System.out.println(a + "|" + b +":" + (a|b));
	}
	public static void main(String[] args) {
		System.out.println("Test " + "abc" + " and " + "def" );
		compareString("abc", "def");
		System.out.println();
		
		System.out.println("Test " + "abc" + " and " + "abc" );
		compareString("abc", "abc");
		System.out.println();
		
		String a = "abc";
		String b = "abc";
		System.out.println("Test var " + a + " and " + b );
		compareString(a, b);
		System.out.println();
	}

}

/**
 * Output:
Test abc and def
abc == def:false
abc != def:true
abc.equals(def):false

Test abc and abc
abc == abc:true
abc != abc:false
abc.equals(abc):true

Test var abc and abc
abc == abc:true
abc != abc:false
abc.equals(abc):true
*/
