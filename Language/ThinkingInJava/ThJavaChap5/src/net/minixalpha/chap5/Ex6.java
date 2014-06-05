/**
 * @author minix
 * @Date Apr 4, 2013 2:11:22 PM
 * @Description
 *		Exercise 6: (1) Modify the previous exercise so that two of the overloaded methods have
 *		two arguments (of two different types), but in reversed order relative to each other. Verify
 *		that this works.
 */

package net.minixalpha.chap5;

class Bird {
	void say(int i, String s) {
		System.out.println(i + " birds say " + "\"" + s + "\"");
	}
	
	void say(String s, int i) {
		System.out.println("\"" + s + "\", " + i + " birds say");
	}
}

public class Ex6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bird bird = new Bird();
		bird.say(5, "hello");
		bird.say("world", 8);
	}
}

/*
Output:
5 birds say "hello"
"world", 8 birds say
*/