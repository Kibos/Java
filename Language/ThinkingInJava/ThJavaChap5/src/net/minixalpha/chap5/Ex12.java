/**
 * @author minix
 * @Date Apr 6, 2013 5:11:50 PM
 * @Description
 *		Exercise 12: (4) Create a class called Tank that can be filled and emptied, and has a
 *		termination condition that it must be empty when the object is cleaned up. Write a
 *		finalize( ) that verifies this termination condition. In main( ), test the possible scenarios
 *		that can occur when your Tank is used.
 */

package net.minixalpha.chap5;

class Tank {
	int bullets;
	
	Tank() {
		bullets = 10;
	}
	
	Tank(int num) {
		bullets = num;
	}
	
	void bang() {
		if (bullets > 0) {
			System.out.println("Bang");
			bullets = bullets - 1;
		}
	}
	
	void fill(int num) {
		bullets = num;
	}
	
	void empty(int num) {
		bullets = 0;
	}
	
	protected void finalize() {
		if (bullets != 0) {
			System.out.println("Error: bullets not empty: " + bullets);
		}
	}
}
public class Ex12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Scenary 0: ");
		Tank tank = new Tank();
		tank.fill(10);
		tank.bang();
		tank.bang();
		new Tank(20);
		System.gc();
		System.out.println("-----------");
		
		System.out.println("Scenary 1: ");
		Tank tank2 = new Tank(100);
		new Tank();
		System.gc();
		System.out.println("-----------");
	}
}

/**
 * Output:
   Scenary 0: 
	 Bang
	 Bang
	 -----------
	 Scenary 1: 
	 Error: bullets not empty: 20
	 -----------
	 Error: bullets not empty: 10
*/

/**
 * Output:
Scenary 0: 
Bang
Bang
Error: bullets not empty: 20
*/