
/**
 * @author minix
 * @Date May 14, 2013 4:55:37 PM
 * @Description
 *		Exercise 12: (3) Add a proper hierarchy of dispose( ) methods to all the classes in
		Exercise 9
 */


package net.minixalpha.chap7;
import static net.mindview.util.Print.print;

class Componenty1 {
	Componenty1() {
		print ("Componenty1's constructor");
	}
	void dispose() {
		print ("dispose Componenty1");
	}
}

class Componenty2 {
	Componenty2() {
		print ("Componenty2's constructor");
	}
	void dispose() {
		print ("dispose Componenty2");
	}
}

class Componenty3 {
	Componenty3() {
		print ("Componenty3's constructor");
	}
	void dispose() {
		print ("dispose Componenty3");
	}
}

class Rooty {
	Rooty() {
		print ("Rooty's constructor");
	}
	void dispose() {
		print ("dispose Rooty");
	}
	Componenty1 cp1 = new Componenty1();
	Componenty2 cp2 = new Componenty2();
	Componenty3 cp3 = new Componenty3();
}

class Stemy extends Rooty {
	Stemy() {
		print ("Stemy's constructor");
	}
	void dispose() {
		print ("dispose Stemy");
		super.dispose();
	}
	Componenty1 cp1 = new Componenty1();
	Componenty2 cp2 = new Componenty2();
	Componenty3 cp3 = new Componenty3();
}

public class Ex12 {
	public static void main(String[] args) {
		Stemy stemy = new Stemy();
		stemy.dispose();
	}
}

/**Output:
Componenty1's constructor
Componenty2's constructor
Componenty3's constructor
Rooty's constructor
Componenty1's constructor
Componenty2's constructor
Componenty3's constructor
Stemy's constructor
dispose Stemy
dispose Rooty
*/
