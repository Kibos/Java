/**
 * @author minix
 * @Date May 12, 2013 5:53:45 PM
 * @Description
 *		Exercise 7: (1) Modify Exercise 5 so that A and B have constructors with arguments
		instead of default constructors. Write a constructor for C and perform all initialization within
		C’s constructor
 */

package net.minixalpha.chap7;

class Ax {
	Ax(int i) { System.out.println("Ax's constructor gets: " + i); }
}
class Bx {
	Bx(int i) { System.out.println("BX's constructor gets: " + i); }
}
class Cx extends Ax{
	Bx bx = new Bx(17);
	Cx(int i) {
		super(i);
		 System.out.println("CX's constructor gets: " + i);
	}
}

public class Ex7 {
	public static void main(String[] args) {
		Cx cx = new Cx(18);
	}
}

/**Output:
Ax's constructor gets: 18
BX's constructor gets: 17
CX's constructor gets: 18
*/