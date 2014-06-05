package net.minixalpha.chap17;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Ex11Demo implements Comparable<Ex11Demo> {
	private Integer data;
	private static Random rand = new Random();

	public Ex11Demo() {
		this.data = rand.nextInt(10);
	}

	@Override
	public int compareTo(Ex11Demo o) {
		return (data < o.data) ? -1 : ((data > o.data) ? 1 : 0);
	}

	public String toString() {
		return data.toString();
	}
}

public class Ex11 {
	public static void main(String[] args) {
		Queue<Ex11Demo> queue = new PriorityQueue<>();
		for (int i = 0; i < 5; i++) {
			queue.add(new Ex11Demo());
		}

		while (queue.isEmpty() == false) {
			System.out.println(queue.poll());
		}
	}
}
