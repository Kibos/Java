package net.minixalpha.chap14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import typeinfo.factory.Factory;

class Part2 {
	public String toString() {
		return getClass().getSimpleName();
	}

	static List<Class<? extends Part>> partFactories = new ArrayList<Class<? extends Part>>();
	static {
		// Collections.addAll() gives an "unchecked generic
		// array creation ... for varargs parameter" warning.
		partFactories.add(FuelFilter.class);
		partFactories.add(AirFilter.class);
		partFactories.add(CabinAirFilter.class);
		partFactories.add(OilFilter.class);
		partFactories.add(FanBelt.class);
		partFactories.add(PowerSteeringBelt.class);
		partFactories.add(GeneratorBelt.class);
	}
	private static Random rand = new Random(47);

	public static Part createRandom() throws InstantiationException,
			IllegalAccessException {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).newInstance();
	}
}

public class Ex14 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Part2 part = new Part2();
		for (int i = 0; i < 10; i++)
			System.out.println(part.createRandom());
	}

}
