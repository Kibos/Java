/**
 * @author minix
 * @Date Apr 6, 2013 5:08:56 PM
 * @Description
 *		Exercise 11: (4) Modify the previous exercise so that your finalize( ) will always be
 *		called.
 */

package net.minixalpha.chap5;

class Job {
	int number;
	Job() {
		number = 1;
		System.out.println("I'm constructor");
	}
	
	Job(int num) {
		this.number = num;
	}
	
	protected void finalize() throws Throwable {
		System.out.println("I'm finalize" + number);
		super.finalize();
	}
}

public class Ex11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Job job = new Job();
		new Job(2);
		System.out.println("----------");
		System.gc();
	}
}

/**
 * Output:
I'm constructor
----------
I'm finalize2
*/