/**
 * @author minix
 * @Date Jun 10, 2013 9:23:20 PM
 * @Description
 *		Create a class called Amphibian. From this, inherit a class called
		Frog. Put appropriate methods in the base class. In main( ), create a Frog and upcast it to
		Amphibian and demonstrate that all the methods still work
 */

package net.minixalpha.chap7;

class Amphibian {
	public void say(Amphibian a) {
		System.out.println("I'm Amphibian");
		a.speak();
	}
	public void speak() {
		System.out.println("Speaking now");
	}
}

class Frog extends Amphibian {
	
}

public class Ex16 {
	public static void main(String[] args) {
		Amphibian test = new Amphibian();
		Frog foo = new Frog();
		test.say(foo);
	}
}

/**
Output:
I'm Amphibian
Speaking now
*/