/**
 * Exercise 5: (2) Create a class called Dog containing two Strings: name and says. In
 * main( ), create two dog objects with names “spot” (who says, “Ruff!”) and “scruffy” (who
 * says, “Wurf!”). Then display their names and what they say.
 */
package net.minixalpha.chap3;

/**
 * @author minix
 *
 */

class Dog {
	String name;
	String says;
}

public class Ex5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dogA = new Dog();
		dogA.name = "spot";
		dogA.says = "Ruff!";
		
		Dog dogB = new Dog();
		dogB.name = "scuffy";
		dogB.says = "Wurf!";
		
		System.out.println("Dog " + dogA.name + " says " + dogA.says);
		System.out.println("Dog " + dogB.name + " says " + dogB.says);
		
	}

}

/**
 * Output:
 * Dog spot says Ruff!
 * Dog scuffy says Wurf!
*/
