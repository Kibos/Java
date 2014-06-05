
package net.minixalpha.chap15;

import java.util.ArrayList;
import java.util.List;

public class Ex29 {

	static void foo(Holder<List<?>> holder) {
		
	}
	
	static void bar(List<Holder<?>> holer) {
		
	}
	
	public static void main(String[] args) {
		Holder holder0 = new Holder();
		Holder<List<Integer>> holder1 = new Holder<List<Integer>>();
		Holder<List<? extends Number>> holder2 = new Holder<List<? extends Number>>();
		Holder<List<? super Integer>> holder3 = new Holder<List<? super Integer>>();
		Holder<List<?>> holder4 = new Holder<>();
		
		foo(holder0);
//		foo(holder1); 
//		foo(holder2);
//		foo(holder3);
		foo(holder4);
		
		List<Holder> list0 = new ArrayList<Holder>();
		List<Holder<Integer>> list1 = new ArrayList<Holder<Integer>>();
		List<Holder<? super Integer>> list2 = new ArrayList<Holder<? super Integer>>();
		List<Holder<? extends Number>> list3 = new ArrayList<Holder<? extends Number>>();
		List<Holder<?>> list4 = new ArrayList<Holder<?>>();
//		bar(list0);
//		bar(list1);
//		bar(list2);
//		bar(list3);
		bar(list4);
	}

}
