/**
 * Exercise 7: (3) Write a program that simulates coin-flipping.
 */
package net.minixalpha.chap3;

import java.util.Random;

/**
 * @author minix
 *
 */

class Coin {
	public boolean flip() {
		Random rand = new Random();
		boolean result = false;
		return rand.nextBoolean();
	}
}
public class Ex7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Coin coin = new Coin();
		int times = 10;
		for (int i=0; i<times; i++) {
			System.out.println("Coin Flipping: " + coin.flip());
		}
	}
}

/*
 * Output 1:
Coin Flipping: false
Coin Flipping: true
Coin Flipping: false
Coin Flipping: false
Coin Flipping: true
Coin Flipping: false
Coin Flipping: false
Coin Flipping: false
Coin Flipping: true
Coin Flipping: true
* Output 2:
Coin Flipping: false
Coin Flipping: true
Coin Flipping: true
Coin Flipping: true
Coin Flipping: false
Coin Flipping: false
Coin Flipping: false
Coin Flipping: false
Coin Flipping: true
Coin Flipping: true
 */
