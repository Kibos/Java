package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}

class NonCollectionSequence extends PetSequence {
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;

			public boolean hasNext() {
				return index < pets.length;
			}

			public Pet next() {
				return pets[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public Iterable<Pet> reverseIterator() {

		return new Iterable<Pet>() {

			@Override
			public Iterator<Pet> iterator() {
				return new Iterator<Pet>() {
					private int index = pets.length - 1;

					@Override
					public boolean hasNext() {
						return index >= 0;
					}

					@Override
					public Pet next() {
						return pets[index--];
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};

	}

	public Iterable<Pet> randomize() {
		return new Iterable<Pet>() {

			@Override
			public Iterator<Pet> iterator() {
				List<Pet> list = new ArrayList<Pet>(Arrays.asList(pets));
				Collections.shuffle(list);
				return list.iterator();
			}
		};

	}

}

public class Ex32 {

	public static void main(String[] args) {
		NonCollectionSequence nc = new NonCollectionSequence();

		InterfaceVsIterator.display(nc.iterator());

		for (Pet pet : nc.reverseIterator()) {
			System.out.print(pet.id() + ":" + pet + " ");
		}
		System.out.println();
		for (Pet pet : nc.randomize()) {
			System.out.print(pet.id() + ":" + pet + " ");
		}
	}

}
