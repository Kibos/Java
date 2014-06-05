/**
 * @author minix
 * Apr 3, 2013 2:52:55 PM
 * @description
 *		
 */

package net.minixalpha.thjava.textbook.chap5;

public class Rock {
	int rockMem;
	
	Rock() {
		System.out.println("Rock no argument");
	}
	
	Rock(int i) {
		rockMem = i;
		System.out.println("Rock has argument");
	}
	public static void main(String[] args) {
		System.out.println("Rock no argu init");
		Rock rockNoArgu = new Rock();
		
		System.out.println("Rock has argu init");
		Rock rockHasArgu = new Rock(8);
	}
}

/**
Output:
Rock no argu init
Rock no argument
Rock has argu init
Rock has argument
*/