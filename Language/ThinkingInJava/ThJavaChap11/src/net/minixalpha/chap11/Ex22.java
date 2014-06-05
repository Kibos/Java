package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class WordsEx22 {
	private String name;
	private int feq;
	
	public WordsEx22(String name, int feq) {
		this.name = name;
		this.feq = feq;
	}
	
	public String getName() {
		return name;
	}
	
	public int getFeq() {
		return feq;
	}
	
	public void setFeq(int feq) {
		this.feq = feq;
	}
	
	public String toString() {
		return name + ":" + feq;
	}
}

public class Ex22 {

	public static void main(String[] args) {
		List<String> wordsList = new ArrayList<String>();
		wordsList.addAll(new TextFile("UniqueWords.java", "\\W+"));
		
		Set<WordsEx22> set = new HashSet<WordsEx22>();
		
		for (String name: wordsList) {
			boolean find = false;
			for (WordsEx22 wdseq: set) {
				if(name.equals(wdseq.getName())) {
					find = true;
					wdseq.setFeq(wdseq.getFeq() + 1);
				}
			}
			
			if (find == false) {
				set.add(new WordsEx22(name, 1));
			}
		}
		
		System.out.println(set);

	}

}
