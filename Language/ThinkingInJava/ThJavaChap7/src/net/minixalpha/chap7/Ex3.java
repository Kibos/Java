/**
 * @minix
 * @Date May 10, 2013 2:00:32 PM
 * @Desciption
 *		Exercise 3: (2) Prove the previous sentence.
 *		the compiler will synthesize a default constructor for you that
		calls the base class constructor
 */
package net.minixalpha.chap7;

import static net.mindview.util.Print.*;
class Art {
	  Art() { print("Art constructor"); }
}

class Drawing extends Art {
  Drawing() { print("Drawing constructor"); }
}

class Cartoon extends Drawing {
 
}
public class Ex3 {
	public static void main(String[] args) {
		Cartoon ct = new Cartoon();
	}
}

/**Output:
Art constructor
Drawing constructor
*/