package net.minixalpha.chap17;

import java.util.*;
import net.mindview.util.*;
import net.minixalpha.chap17.ListPerformance29.ListTester;


class FastTraversalLinkedList extends AbstractList<String> {

	private LinkedList<String> llList = new LinkedList<>();
	private ArrayList<String> arList = new ArrayList<>();
	private boolean modified = false;

	@Override
	public boolean add(String e) {
		boolean llR = llList.add(e);
		modified = true;
		return llR;
	}

	@Override
	public String get(int index) {
		if (modified) {
			arList.clear();
			arList.addAll(llList);
			modified = false;
		}
		return arList.get(index);
	}

	@Override
	public int size() {
		return llList.size();
	}

	@Override
	public void clear() {
		llList.clear();
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		boolean llR = llList.addAll(c);
		return llR;
	}

}

public class Ex33 {
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
		ListTester.run(new FastTraversalLinkedList(), tests);
	}
}
