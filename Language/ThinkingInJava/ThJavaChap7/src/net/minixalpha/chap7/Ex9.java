/**
 * @author minix
 * @Date May 12, 2013 6:02:48 PM
 * @Description
 *		Exercise 9: (2) Create a class called Root that contains an instance of each of the classes
		(that you also create) named Component1, Component2, and Component3. Derive a
		class Stem from Root that also contains an instance of each “component.” All classes should
		have default constructors that print a message about that class.

 */

package net.minixalpha.chap7;
import static net.mindview.util.Print.*;

class Component1 {
	Component1() {
		print ("Component1's constructor");
	}
}

class Component2 {
	Component2() {
		print ("Component2's constructor");
	}
}

class Component3 {
	Component3() {
		print ("Component3's constructor");
	}
}

class Root {
	Root() {
		print ("Root's constructor");
	}
	Component1 cp1 = new Component1();
	Component2 cp2 = new Component2();
	Component3 cp3 = new Component3();
}

class Stem extends Root {
	Stem() {
		print ("Stem's constructor");
	}
	Component1 cp1 = new Component1();
	Component2 cp2 = new Component2();
	Component3 cp3 = new Component3();
}

public class Ex9 {

	public static void main(String[] args) {
		Stem stem = new Stem();
	}
}

/**Output:
Component1's constructor
Component2's constructor
Component3's constructor
Root's constructor
Component1's constructor
Component2's constructor
Component3's constructor
Stem's constructor
*/