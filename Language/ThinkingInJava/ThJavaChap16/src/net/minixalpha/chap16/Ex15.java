package net.minixalpha.chap16;

import java.util.*;

import net.mindview.util.Generated;
import net.mindview.util.Generator;
import static net.mindview.util.Print.*;

class BerylliumSphere15 {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return "Sphere " + id;
	}
}

class BerylliumSphere15Generator implements Generator<BerylliumSphere15> {

	@Override
	public BerylliumSphere15 next() {
		return new BerylliumSphere15();
	}

}

class ContainerComparison {
	static void oriTest() {
		BerylliumSphere15[] spheres = new BerylliumSphere15[10];
		for (int i = 0; i < 5; i++)
			spheres[i] = new BerylliumSphere15();
		print(Arrays.toString(spheres));
		print(spheres[4]);

		List<BerylliumSphere15> sphereList = new ArrayList<BerylliumSphere15>();
		for (int i = 0; i < 5; i++)
			sphereList.add(new BerylliumSphere15());
		print(sphereList);
		print(sphereList.get(4));

		int[] integers = { 0, 1, 2, 3, 4, 5 };
		print(Arrays.toString(integers));
		print(integers[4]);

		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0, 1, 2,
				3, 4, 5));
		intList.add(97);
		print(intList);
		print(intList.get(4));
	}

	static void newTest() {
		BerylliumSphere15[] bs = Generated.array(BerylliumSphere15.class,
				new BerylliumSphere15Generator(), 3);
		System.out.println(Arrays.deepToString(bs));
	}

	public static void main(String[] args) {
		newTest();
	}
}

public class Ex15 {
	public static void main(String[] args) {

	}
}
