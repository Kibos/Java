/**
 * @author minix
 * @Date Apr 8, 2013 10:17:35 PM
 * @Description
 *		Exercise 13: (1) Verify the statements in the previous paragraph.
 *		
 */

package net.minixalpha.chap5;


class Cup {
	Cup (int marker) {
		System.out.println("Cup(" + marker + ")");
	}
	
	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	
	Cups() {
		System.out.println("Cups()");
	}
}

public class Ex13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Inside main()");
		Cups.cup1.f(99);
	}
	
	static Cups cups1 = new Cups(); //(1)
//	static Cups cups2 = new Cups(); //(2)
}

/**
Output:(If comment (1) and (2)
Inside main()
Cup(1)
Cup(2)
f(99)
*/

/**
Output: (If not comment (1) and (2))
Cup(1)
Cup(2)
Cups()
Cups()
Inside main()
f(99)
*/  

/**
Output: If only comment (1)
Cup(1)
Cup(2)
Cups()
Inside main()
f(99)
*/

/**
Output: If only comment (2)
Cup(1)
Cup(2)
Cups()
Inside main()
f(99)
*/