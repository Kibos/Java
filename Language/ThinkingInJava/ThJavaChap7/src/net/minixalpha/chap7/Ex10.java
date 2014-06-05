/**
 * @author minix
 * @Date May 12, 2013 7:04:12 PM
 * @Description
 *		Exercise 10: (1) Modify the previous exercise so that each class only has non-default
		constructor
 */

package net.minixalpha.chap7;

import static net.mindview.util.Print.print;

class Component1x {
	Component1x(int i) {
		print ("Component1's constructor: " + i);
	}
}

class Component2x {
	Component2x(int i) {
		print ("Component2's constructor: " + i);
	}
}

class Component3x {
	Component3x(int i) {
		print ("Component3's constructor: " + i);
	}
}

class Rootx {
	Rootx(int i) {
		print ("Root's constructor: " + i);
	}
	Component1x cp1 = new Component1x(1);
	Component2x cp2 = new Component2x(2);
	Component3x cp3 = new Component3x(3);
}

class Stemx extends Rootx {
	Stemx(int i) {
		super(i);
		print ("Stem's constructor: " + i);
	}
	Component1x cp1 = new Component1x(4);
	Component2x cp2 = new Component2x(5);
	Component3x cp3 = new Component3x(6);
}


public class Ex10 {
	public static void main(String[] args) {
		Stemx stemx = new Stemx(10);
	}
}

/**Output:
Component1's constructor: 1
Component2's constructor: 2
Component3's constructor: 3
Root's constructor: 10
Component1's constructor: 4
Component2's constructor: 5
Component3's constructor: 6
Stem's constructor: 10
*/