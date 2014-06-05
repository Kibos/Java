package net.minixalpha.chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;
import net.minixalpha.chap17.ListPerformance29.ListTester;

public class Ex30 {
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

		tests.add(new Test<List<String>>("Collection.sort") {

			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++) {
					Collections.sort(list);
				}
				return loops * listSize;
			}
		});
	}

	public static void main(String[] args) {
		Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000,
				10000, 200);
		if (args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		ListTester.run(new ArrayList<String>(), tests);
		ListTester.run(new LinkedList<String>(), tests);
	}
}
