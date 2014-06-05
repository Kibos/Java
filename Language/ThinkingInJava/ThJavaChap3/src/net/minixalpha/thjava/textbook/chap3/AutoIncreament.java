/**
 * Test Auto Increment
 */
package net.minixalpha.thjava.textbook.chap3;

/**
 * @author minix
 *
 */

class PreIncre {
	int num;
	public int getIncreNum() {
		num = 0;
		return ++num;
	}
}

class PostIncre {
	int num;
	public int getIncreNum() {
		num = 0;
		return num++;
	}
}
public class AutoIncreament {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PreIncre preI = new PreIncre();
		System.out.println("PreIncrease num is: " + preI.getIncreNum());
		
		PostIncre postI = new PostIncre();
		System.out.println("PostIncrease num is: " + postI.getIncreNum());
	}
}

/**
 * Output:
 * PreIncrease num is: 1
 * PostIncrease num is: 0
 */
