package net.minixalpha.chap15;

import net.mindview.util.*;
import static net.mindview.util.Tuple.*;

class TupleTest2 {
	static TwoTuple<String, Integer> f() {
		return tuple("hi", 47);
	}

	static TwoTuple f2() {
		return tuple("hi", 47);
	}

	static ThreeTuple<Amphibian, String, Integer> g() {
		return tuple(new Amphibian(), "hi", 47);
	}

	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}

	static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}
	
	static net.mindview.util.SixTuple<Vehicle, Amphibian, String, Integer, Double, Boolean> l() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1, false);
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		TwoTuple<String, Integer> test = f2(); // Type safe warning
		System.out.println(test);
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
		System.out.println(l());
	}
}

public class Ex15 {
	public static void main(String[] args) {
		TupleTest2 test2 = new TupleTest2();
		test2.main(null);
	}
}
