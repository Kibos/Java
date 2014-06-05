
package net.minixalpha.chap11;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex28 {

	public static void main(String[] args) {
		Queue<Double> queue = new PriorityQueue<Double>(Arrays.asList(2.0, 3.1, -1.2));
		Double head;
		while((head = queue.poll()) != null) {
			System.out.println(head);
		}
	}

}
