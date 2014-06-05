package net.minixalpha.chap18;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;

interface Ex11Demo {
	public void run();
}

class LightOn implements Ex11Demo {
	private int n;

	public LightOn(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		System.out.println("LightOn " + n);
	}

}

class LightOff implements Ex11Demo {
	private int n;

	public LightOff(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		System.out.println("LightOff " + n);
	}

}

public class Ex11 {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, NoSuchMethodException, SecurityException,
			NumberFormatException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		List<Ex11Demo> demos = new ArrayList<>();

		String name = "events.txt";
		BufferedReader reader = new BufferedReader(new FileReader(name));
		LinkedList<String> lines = new LinkedList<>();
		String line;
		while ((line = reader.readLine()) != null) {
			String[] e = line.split(" ");
			String event = e[0];
			String arg = e[1];

			Class<?> c = Class.forName("net.minixalpha.chap18." + event);
			Constructor<?> cons = c.getConstructor(int.class);
			demos.add((Ex11Demo) cons.newInstance(new Integer(arg)));
		}

		for (Ex11Demo d : demos) {
			d.run();
		}
	}
}
