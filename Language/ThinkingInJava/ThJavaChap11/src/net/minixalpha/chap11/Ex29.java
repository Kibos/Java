package net.minixalpha.chap11;

import java.util.PriorityQueue;
import java.util.Queue;

class DemoEx29 {

}

public class Ex29 {

	public static void main(String[] args) {
		Queue<DemoEx29> queue = new PriorityQueue<DemoEx29>();
		queue.add(new DemoEx29());
		queue.add(new DemoEx29());

		// when run, you will get exception
	}

}
