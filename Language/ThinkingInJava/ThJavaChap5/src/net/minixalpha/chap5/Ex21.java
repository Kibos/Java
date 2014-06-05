/**
 * @author minix
 * @Date Apr 12, 2013 10:09:46 PM
 * @Description
 *		Exercise 21: (1) Create an enum of the least-valuable six types of paper currency. Loop
 *		through the values( ) and print each value and its ordinal( ).
 */

package net.minixalpha.chap5;

enum LeastValuablePaper {
	A4, POLITICS, MAXIEGS,
	WHOKNOW,B5,CHIP,GPS
}

public class Ex21 {

	public static void main(String[] args) {
		for (LeastValuablePaper item: LeastValuablePaper.values()) {
			System.out.println(item + " original :" + item.ordinal());
		}
	}
}

/*
Output:
A4 original :0
POLITICS original :1
MAXIEGS original :2
WHOKNOW original :3
B5 original :4
CHIP original :5
GPS original :6
*/