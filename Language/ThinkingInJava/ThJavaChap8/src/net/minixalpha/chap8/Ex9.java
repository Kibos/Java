/**
 * @author 
 * @Date Jun 17, 2013 4:46:18 PM
 * @Description
 * 		Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,
		etc. In the base class, provide methods that are common to all Rodents, and override these
		in the derived classes to perform different behaviors depending on the specific type of
		Rodent. Create an array of Rodent, fill it with different specific types of Rodents, and call
		your base-class methods to see what happens
 */
package net.minixalpha.chap8;

class Rodent {
	String className() {
		return "Rodent";
	}
}

class Mouse extends Rodent{
	String className() {
		return "Mouse";
	}
}

class Gerbil extends Rodent{
	String className() {
		return "Gerbil";
	}
}
public class Ex9 {
	public static void main(String[] args) {
		Rodent[] rodents = {
				new Mouse(), new Gerbil()
		};
		
		for (Rodent rodent: rodents) {
			System.out.println(rodent.className());
		}
	}
}

/**
Output:
Mouse
Gerbil
*/

