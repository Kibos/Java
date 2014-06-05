/**
 * @author minix
 * @Date Apr 12, 2013 10:14:03 PM
 * @Description
 *		Exercise 22: (2) Write a switch statement for the enum in the previous example. For
 *		each case, output a description of that particular currency.
 */

package net.minixalpha.chap5;

enum LeastValuablePaperShade {
	A4, POLITICS, MAXIEGS,
	WHOKNOW,B5,CHIP,GPS
}

public class Ex22 {

	public static void main(String[] args) {
		LeastValuablePaperShade item = LeastValuablePaperShade.MAXIEGS;
		
		switch(item) {
			case A4:
				System.out.println(item + "is a kind of paper");
				break;
			case MAXIEGS:
				System.out.println("Who knows what the " + item + " is?");
				break;
			case B5:
				System.out.println(item + "is also kind of paper");
				break;
			default:
				break;
		}
		
	}
}

/*
 * Output:
 * Who knows what the MAXIEGS is?
 */
