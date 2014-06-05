package net.minixalpha.chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.mindview.util.TextFile;

class DataCollection {
	private static String[] dataSource;

	private String[] filterWrods(String[] words) {
		List<String> wordsList = new ArrayList<>(words.length);
		for (String word : words) {
			if (word.length() > 0) {
				wordsList.add(word);
			}
		}
		String[] filteredWrods = new String[wordsList.size()];
		int i = 0;
		for (String word : wordsList) {
			filteredWrods[i++] = word;
		}
		return filteredWrods;
	}

	public DataCollection(String filePath) {
		String[] words = TextFile.read(filePath).split("\\W+");
		dataSource = filterWrods(words);
	}

	public static Words getData() {
		return new Words();
	}

	public static class Words implements Iterator<String> {
		private int index = 0;

		public String next() {
			return dataSource[index++];
		}

		@Override
		public boolean hasNext() {
			return index < dataSource.length;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}

public class Ex4 {

	static void testCase1() {
		DataCollection.Words data1 = DataCollection.getData();
		while (data1.hasNext()) {
			System.out.print(data1.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DataCollection dc = new DataCollection("news.txt");
		testCase1();
		testCase1();
	}
}
