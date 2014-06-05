/**
 * 
 */
package net.minixalpha.thjava.textbook.chap3;

/**
 * @author minix
 *
 */
public class ShortCircuit {

	/**
	 * @param args
	 */
	static boolean test1(int num ){
		System.out.println("test1(" + num + ")");
		return num < 1;
	}
	
	static boolean test2(int num ){
		System.out.println("test2(" + num + ")");
		return num < 2;
	}
	static boolean test3(int num ){
		System.out.println("test3(" + num + ")");
		return num < 3;
	}
	
	public static void main(String[] args) {
		// test of && will end when encounter a false
		System.out.println( "Test Short Circuit of &&");;
		boolean b = test1(0) && test2(3) && test3(2);
		
		// test of || will end when encounter a true
		System.out.println( "Test Short Circuit of ||");;
		boolean c = test1(2) || test2(1) || test3(5);
	}

}

/**
 * Output:
Test Short Circuit of &&
test1(0)
test2(3)
Test Short Circuit of ||
test1(2)
test2(1)
 */
