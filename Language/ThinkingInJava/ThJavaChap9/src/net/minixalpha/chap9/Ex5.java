
package net.minixalpha.chap9;

import ForEx.ForEx5;

class ImpleForEx5 implements ForEx5 {
	public void say() {
		System.out.println("ImplementForEx5");
	}
}

public class Ex5 {

	public static void main(String[] args) {
		ForEx5 forEx5 = new ImpleForEx5();
		forEx5.say();
	}

}
