/**
 * Exercise 10: (2) Write a program that prints three arguments taken from the command
 * line. To do this, you’ll need to index into the command-line array of Strings
 */
package net.minixalpha.chap2;

/**
 * @author minix
 *
 */
public class Ex10 {
	public void printArgs(String[] args) {
		int len = args.length;
		int count = (len > 3) ? 3 : len;
		for (int i=0; i<count; i++) {
			System.out.print(args[i] + " ");
		}
		System.out.println();
	}
}
