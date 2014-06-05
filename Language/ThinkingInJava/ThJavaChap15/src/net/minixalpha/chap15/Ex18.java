package net.minixalpha.chap15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;



class BigFish {
	static Random random = new Random();
	public String toString() {
		return BigFish.class.getSimpleName() + random.nextInt(4);
	}
	
	public static Generator<BigFish> generator() {
		
		return new Generator() {

			@Override
			public Object next() {
				return new BigFish();
			}
		};
	}
}

class LittleFish {
	public String toString() {
		return LittleFish.class.getSimpleName();
	}
	
	public static Generator<LittleFish> generator = new Generator() {

		@Override
		public Object next() {
			return new LittleFish();
		}
	};
}

public class Ex18 {
	class Generators {
		public <T> Collection<T> fill(Collection<T> coll, Generator<T> gen,
				int n) {
			for (int i = 0; i < n; i++)
				coll.add(gen.next());
			return coll;
		}

		public <T> Collection<T> fill(List<T> coll, Generator<T> gen, int n) {
			for (int i = 0; i < n; i++)
				coll.add(gen.next());
			return coll;
		}

		public <T> Collection<T> fill(Queue<T> coll, Generator<T> gen, int n) {
			for (int i = 0; i < n; i++)
				coll.add(gen.next());
			return coll;
		}
	}
	public static void main(String[] args) {
		Ex18 ex18 = new Ex18();
		Generators generators = ex18.new Generators();
		Random random = new Random(23);
		Queue<BigFish> bigFishs = new LinkedList<>();
		generators.fill(bigFishs, BigFish.generator(), 4);
		List<LittleFish> littleFishs = new ArrayList<>();
		generators.fill(littleFishs, LittleFish.generator, 4);
		
		for (BigFish fish: bigFishs) {
			System.out.println(fish + " eat " + littleFishs.get(random.nextInt(littleFishs.size())));
		}
	}
}
