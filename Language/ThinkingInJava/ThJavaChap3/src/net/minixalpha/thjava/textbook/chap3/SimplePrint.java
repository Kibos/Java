/**
 * 
 */
package net.minixalpha.thjava.textbook.chap3;

import java.util.*;
import static net.mindview.util.Print.*;

/**
 * Purpose of this class is:
 * 1. Learn to set classpath of external class dir
 * 2. Use external class
 * 3. Import class in a "static" way
 * 4. Show some print features
 * 
 * @author minix
 * 
 */
public class SimplePrint {
	public static void main(String[] args) {
		// Output string in two ways
		System.out.println("Complex way to output");
		print("Simple way to output");
		
		// Output non-string type using "+"
		int a = 5;
		print("Output an integer using + :" + a);
		
		
	}

}
