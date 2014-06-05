/**
 * @author minix
 * @Date Jun 10, 2013 10:49:29 PM
 * @Description
 *		Prove that class loading takes place only once. Prove that loading may
		be caused by either the creation of the first instance of that class or by the access of a static
		member.
 */

package net.minixalpha.chap7;

class LoadClassOnce {
	static int staticVar = printLine();
	
	static int printLine() {
		System.out.println("foo");
		return 7;
	}
}

class LoadClassOnce2 {
	static int staticVar = printLine();
	
	static int printLine() {
		System.out.println("foo");
		return 7;
	}
}

class LoadClassByVisitStatic {
	static int staticVar = printLine();
	
	static int printLine() {
		System.out.println("foo twice");
		return 7;
	}
}

public class Ex23 {
	public static void main(String[] args) {
		System.out.println("Load Class once:");
		LoadClassOnce c1 = new LoadClassOnce();
		LoadClassOnce c2 = new LoadClassOnce();
		
		System.out.println("Visit static var");
		System.out.println(LoadClassByVisitStatic.staticVar);
		
		LoadClassOnce2 c3; // not load class
	}
}

/**
Output:
Load Class once:
foo
Visit static var
foo twice
7
*/