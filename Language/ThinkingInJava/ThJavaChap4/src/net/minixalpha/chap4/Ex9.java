/**
 * @author minix
 * @date Apr 2, 2013 3:47:49 PM
 * @Description:
 *      Exercise 9: (4) A Fibonacci sequence is the sequence of numbers 1, 1, 2, 3, 5, 8, 13, 21,
 *		34, and so on, where each number (from the third on) is the sum of the previous two. Create
 *		a method that takes an integer as an argument and displays that many Fibonacci numbers
 *		starting from the beginning, e.g., If you run java Fibonacci 5 (where Fibonacci is the
 *		name of the class) the output will be: 1, 1, 2, 3, 5.

 */

package net.minixalpha.chap4;

public class Ex9 {

	static void printFibo(int n) {
		int a = 1, b = 1;
		int next = 0;
		System.out.print("1 ");
		for (int i=1; i<n; i++) {
			System.out.print(b + " ");
			next = a + b;
			a = b;
			b = next;
		}
	}
	public static void main(String[] args) {
		for (int i=1; i<10; i++) {
			printFibo(i);
			System.out.println();
		}
	}

}

/**
Output:
1 
1 1 
1 1 2 
1 1 2 3 
1 1 2 3 5 
1 1 2 3 5 8 
1 1 2 3 5 8 13 
1 1 2 3 5 8 13 21 
1 1 2 3 5 8 13 21 34 
*/