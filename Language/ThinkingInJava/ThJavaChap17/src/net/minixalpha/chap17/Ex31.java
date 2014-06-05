package net.minixalpha.chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;
import net.minixalpha.chap17.ListPerformance29.ListTester;

class StringArray implements List<String> {
	private String[] strings;
	private int size;
	private int count;
	private int DEFAULT_SIZE = 8;

	public StringArray() {
		this.size = DEFAULT_SIZE;
		this.strings = new String[size];
		this.count = 0;
	}

	public StringArray(int size) {
		this.size = size;
		this.strings = new String[size];
		this.count = 0;
	}

	private void extendSize(int newSize) {
		String[] newStrings = new String[newSize];
		for (int i = 0; i < size; i++) {
			newStrings[i] = strings[i];
		}
		strings = newStrings;
		// System.arraycopy(strings, 0, newStrings, 0, size);
//		strings = Arrays.copyOf(strings, newSize);

		size = newSize;
	}

	public boolean add(String str) {
		if (count >= size) {
			extendSize(size + (size >> 1));
		}
		strings[count++] = str;
		return true;
	}

	public String get(int i) {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return strings[i];
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		for(String str: c) {
			add(str);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for(int i=0; i<count; i++) {
			strings[i] = null;
		}
		count = 0;
	}

	@Override
	public String set(int index, String element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub

	}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}

public class Ex31 {
	static Random rand = new Random();
	static int reps = 1000;
	static List<Test<List<String>>> tests = new ArrayList<Test<List<String>>>();
	static List<Test<LinkedList<String>>> qTests = new ArrayList<Test<LinkedList<String>>>();
	static {
		tests.add(new Test<List<String>>("add") {
			Generator<String> gen = new CountingGenerator.String();

			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					for (int j = 0; j < listSize; j++)
						list.add(gen.next());
				}
				return loops * listSize;
			}
		});

		tests.add(new Test<List<String>>("get") {
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for (int i = 0; i < loops; i++)
					list.get(rand.nextInt(listSize));
				return loops;
			}
		});
	}

	public static void main(String[] args) {
		Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000,
				10000, 200);
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		ListTester.run(new ArrayList<String>(), tests);
		ListTester.run(new StringArray(), tests);
	}
}