/**
 * @minix
 * @Date May 7, 2013 4:57:49 PM
 * @Desciption
 *		Exercise 3: (2) Create two packages: debug and debugoff, containing an identical class
 *		with a debug( ) method. The first version displays its String argument to the console, the
 *		second does nothing. Use a static import line to import the class into a test program, and
 *		demonstrate the conditional compilation effect.
 */

package net.minixalpha.chap6;
import static debug.Ex3Class.*;
//import static debugoff.Ex3Class.*;
public class Ex3 {
	public static void main(String[] args) {
		debug(args);
	}
}

/**Output
if import static debug.Ex3Class.*;
arg0 arg1 arg2 
--------
if import static debugoff.Ex3Class.*;

*/