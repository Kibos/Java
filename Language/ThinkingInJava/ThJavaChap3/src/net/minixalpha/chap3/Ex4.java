/**
 * Exercise 4: (2) Write a program that calculates velocity using a constant distance and a
 * constant time.
 */
package net.minixalpha.chap3;

import static net.mindview.util.Print.*;

import java.util.Random;

/**
 * Points:
 * 	1. Random data
 *  2. Division
 * @author minix
 *
 */
public class Ex4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// rand of this way will get the current time as 
		// seed
		Random rand = new Random();
		double distance = rand.nextDouble();
		double time = rand.nextDouble();
		while (time == 0) {
			time = rand.nextDouble();
		}
		
		print ("Distance is :" + distance);
		print ("Time is : " + time);
		
		double velocity = distance / time;
		print ("Velocity is : " + velocity);
		
		print ("-----------------------------");
		
		// Give a seed to randomer
		// Then distanceLT100 and timeLT5 will
		// be the same each time
		Random randActSeed = new Random(24);
		double distanceLT100 = randActSeed.nextInt(100);
		
		// Only nextInt can give the Upper Bound
		double timeLT5 = randActSeed.nextInt(5);
		while (timeLT5 == 0) {
			timeLT5 = randActSeed.nextInt(5);
		}
		
		print ("Distance(>100) is :" + distanceLT100);
		print ("Time(>5) is :" + timeLT5);
		double curTime = distanceLT100 / timeLT5;
		print ("CurVelocity is " + curTime);
	}

}

/**
 * Output1:
 * Distance is :0.453284770013174
 * Time is : 0.6249158131439999
 * Velocity is : 0.7253533363680832
 * -----------------------------
 * Distance(>100) is :55.0
 * Time(>5) is :1.0
 * CurVelocity is 55.0
 * 
 * */

/**
 * Distance is :0.3049667635895842
 * Time is : 0.964553175579099
 * Velocity is : 0.3161741325526071
 * -----------------------------
 * Distance(>100) is :55.0
 * Time(>5) is :1.0
 * CurVelocity is 55.0
 * 
 */
 

