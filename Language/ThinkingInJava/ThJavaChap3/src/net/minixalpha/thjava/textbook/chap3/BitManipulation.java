/**
 * Using the bitwise operators
 */
package net.minixalpha.thjava.textbook.chap3;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * @author minix
 *
 */

public class BitManipulation {

	/**
	 * @param args
	 */
	static void printBinaryInt(String s, int i ) {
		print ( s + ", int: " + i + ", binary:\n	" +
				Integer.toBinaryString(i));
	}
	
	static void printBinaryLong(String s, long i ) {
		print ( s + ", int: " + i + ", binary:\n	" +
				Long.toBinaryString(i));
	}
	
	public static void main(String[] args) {
		Random rand = new Random(47);
		int i = rand.nextInt();
		int j = rand.nextInt();
		printBinaryInt("-1", -1);
		printBinaryInt("+1", +1);
		
		int maxpos = 2147483647;
		printBinaryInt("maxpos", maxpos);
		int maxneg = -2147483648;
		printBinaryInt("maxneg", maxneg);
		printBinaryInt("i", i);
		printBinaryInt("~i", ~i);
		printBinaryInt("-i", -i);
		printBinaryInt("j", j);
		printBinaryInt("i & j", i & j);
		printBinaryInt("i | j", i | j);
		printBinaryInt("i ^ j", i ^ j);
		printBinaryInt("i << 5", i << 5);
		printBinaryInt("i >> 5", i >> 5);
		printBinaryInt("(~i) >> 5", (~i) >> 5);
		printBinaryInt("i >>> 5", i >>> 5);
		printBinaryInt("(~i) >>> 5", (~i) >>> 5);
		
	}

}
