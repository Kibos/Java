/**
 * @author minix
 * @Date May 12, 2013 5:42:01 PM
 * @Description
 *		Exercise 4: (2) Prove that the base-class constructors are (a) always called and (b) called
		before derived-class constructors

 */

package net.minixalpha.chap7;

import static net.mindview.util.Print.*;

class Arts {
	  Arts() { print("Arts constructor"); }
}

class Drawings extends Art {
  Drawings() { print("Drawings constructor"); }
}

class Cartoons extends Drawing {
	Cartoons() {print("Cartoons constructor"); }
}

public class Ex4 {
	public static void main(String[] args) {
		Cartoons cts = new Cartoons();
	}
}

/**Output:
Art constructor
Drawing constructor
Cartoons constructor
*/