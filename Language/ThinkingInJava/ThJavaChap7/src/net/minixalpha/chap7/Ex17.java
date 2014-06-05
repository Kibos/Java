/**
 * @author minix
 * @Date Jun 10, 2013 9:28:01 PM
 * @Description
 *		
 */

package net.minixalpha.chap7;

class Amphibian17 {
	public void say(Amphibian17 a) {
		System.out.println("I'm Amphibian");
		a.speak();
	}
	public void say(Frog17 a) {
		System.out.println("I'm Amphibian");
		a.speak();
	}
	public void speak() {
		System.out.println("Amphibian is speaking now ");
	}
}

class Frog17 extends Amphibian17 {
	public void speak() {
		System.out.println("Amphibian is speaking now ");
	}
}
public class Ex17 {
	public static void main(String[] args) {
		Amphibian17 test = new Amphibian17();
		Frog17 foo = new Frog17();
		test.say(foo);
	}
}

/**
Output:
I'm Amphibian
Amphibian is speaking now 
*/