/**
 * @author minix
 * @date Mar 31, 2013 4:56:44 PM
 * @Description 
 * 		Exercise 2: (2) Write a program that generates 25 random int values. For each value,
 *		use an if-else statement to classify it as greater than, less than, or equal to a second
 *		randomly generated value.
 */

package net.minixalpha.chap4;

import java.util.Random;

/**
 * 
 */
public class Ex2 {

	/**
	 * @param args
	 */
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
		int i;
		for (i=0; i<24; i++) {
			int next = rand.nextInt();
			System.out.println(i + ": " + pre + compare(pre, next) + "next rand number" );
			pre = next;
		}
		System.out.println(i  + ": " + pre + " ? " + "next rand number");
	}

}

/**
Output:
0: -616763724 greater than next rand number
1: -802700474 greater than next rand number
2: -1625096814 less than next rand number
3: 1050999292 greater than next rand number
4: 862885125 greater than next rand number
5: 702221901 less than next rand number
6: 1106598933 less than next rand number
7: 2067050213 greater than next rand number
8: 1365121960 greater than next rand number
9: 1022519880 greater than next rand number
10: -698708580 less than next rand number
11: 463443430 greater than next rand number
12: -678387239 greater than next rand number
13: -1057505443 greater than next rand number
14: -1586087445 less than next rand number
15: -616898689 less than next rand number
16: -408866798 greater than next rand number
17: -1134533159 greater than next rand number
18: -1222832898 greater than next rand number
19: -1375320889 less than next rand number
20: 222799753 less than next rand number
21: 392280419 less than next rand number
22: 1183325227 greater than next rand number
23: 186412996 greater than next rand number
24: -211769859 ? next rand number
*/