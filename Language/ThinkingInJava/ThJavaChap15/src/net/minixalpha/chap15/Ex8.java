package net.minixalpha.chap15;

import java.util.*;

class StoryCharacter {
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

class GoodGuys extends StoryCharacter {

}

class BadGuys extends StoryCharacter {

}

class StoryCharacterGenerator implements Generator<StoryCharacter>,
		Iterable<StoryCharacter> {
	private Class[] types = { GoodGuys.class, BadGuys.class };
	Random random = new Random(43);
	int count;

	public StoryCharacterGenerator(int count) {
		this.count = count;
	}

	@Override
	public Iterator<StoryCharacter> iterator() {
		return new Iterator<StoryCharacter>() {

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public StoryCharacter next() {
				count--;
				return StoryCharacterGenerator.this.next();
			}

			@Override
			public boolean hasNext() {
				return count > 0;
			}
		};
	}

	@Override
	public StoryCharacter next() {
		try {
			return (StoryCharacter) types[random.nextInt(types.length)]
					.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}

public class Ex8 {
	public static void main(String[] args) {
		StoryCharacterGenerator generator = new StoryCharacterGenerator(10);
		Iterator<StoryCharacter> iterator = generator.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
