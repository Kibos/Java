//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
package net.minixalpha.chap11.controller;

import java.util.*;

public class Controller {
	// A class from java.util to hold Event objects:
	private List<Event> eventList = new LinkedList<Event>();

	public void addEvent(Event c) {
		eventList.add(c);
	}

	public void run() {
		Iterator<Event> eventsIterator = eventList.iterator();
		
		while (eventList.size() > 0)
			// Make a copy so you're not modifying the list
			// while you're selecting the elements in it:
			while ( eventsIterator.hasNext()) {
				Event e = eventsIterator.next();
				if (e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
				eventsIterator = eventList.iterator();
			}
	}
} // /:~
