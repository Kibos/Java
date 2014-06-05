package net.minixalpha.chap15;

import java.util.*;

public class Ex13 {
	class Coffee {
	}

	class CoffeeGenerator implements Generator {

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	class Generators {
		public <T> Collection<T> fill(Collection<T> coll, Generator<T> gen,
				int n) {
			for (int i = 0; i < n; i++)
				coll.add(gen.next());
			System.out.println("hitom");
			return coll;
		}

		public <T> Collection<T> fill(List<T> coll, Generator<T> gen, int n) {
			for (int i = 0; i < n; i++)
				coll.add(gen.next());
			System.out.println("hijack");
			return coll;
		}

		public <T> Collection<T> fill(Queue<T> coll, Generator<T> gen, int n) {
			for (int i = 0; i < n; i++)
				coll.add(gen.next());
			System.out.println("hijack");
			return coll;
		}

		public void main(String[] args) {
			Collection<Coffee> coffee = fill(new ArrayList<Coffee>(),
					new CoffeeGenerator(), 4);
			for (Coffee c : coffee)
				System.out.println(c);
			System.out.println("--");
			Collection<Integer> fnumbers = fill(new HashSet<Integer>(),
					new Fibonacci(), 12);
			for (int i : fnumbers)
				System.out.print(i + ", ");
			System.out.println("--");
//			Collection<Integer> fnumbersx = fill(new LinkedList<Integer>(),
//					new Fibonacci(), 12);
//			for (int i : fnumbersx)
//				System.out.print(i + ", ");
		}
	}

	public static void main(String[] args) {
		Generators gen = new Ex13().new Generators();
		gen.main(null);
	}

}
