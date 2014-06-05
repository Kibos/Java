package net.minixalpha.chap11;

import java.util.LinkedList;
import java.util.Queue;

class Command {
	private String name;
	
	public Command(String name) {
		this.name = name;
	}
	
	public void operation() {
		System.out.println(name);
	}
}

class QueueDemo2 {
	public static Command fill(Queue<Command> queue, Command o) {
		queue.offer(o);
		return o;
	}
}

class QueueDemo3 {
	public static void consume(Queue<Command> queue) {
		while (queue.peek() != null) {
			Command head = queue.remove();
			head.operation();
		}
	}
}

public class Ex27 {

	public static void main(String[] args) {
		Queue<Command> queue = new LinkedList<Command>();
		QueueDemo2.fill(queue, new Command("harry"));
		QueueDemo2.fill(queue, new Command("ron"));
		QueueDemo3.consume(queue);
	}

}
