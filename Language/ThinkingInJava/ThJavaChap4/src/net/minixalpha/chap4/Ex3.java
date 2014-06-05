/**
 * @author minix
 * @date Mar 31, 2013 5:08:41 PM
 * @Description:
 *     Exercise 3: (1) Modify Exercise 2 so that your code is surrounded by an “infinite” while
 *     loop. It will then run until you interrupt it from the keyboard (typically by pressing Control-
 *		C).
 */

package net.minixalpha.chap4;

import java.util.Random;


public class Ex3 {

	static String compare(int a, int b) {
		if (a == b ){
			return " equal to ";
		} else {
			if (a > b ){
				return " greater than ";
			} else {
				return " less than ";
			}
		}
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int pre = rand.nextInt();
		int i = 0;
		while(true) {
			int next = rand.nextInt();
			System.out.println(i + ": " + pre + compare(pre, next) + "next rand number" );
			pre = next;
			i = i + 1;
		}
	}
}
