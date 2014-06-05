
package net.minixalpha.chap11;

import java.util.*;

public class TestGenerics {
	
	static class Apple {
		private void sayApple() {
		}
	}
	
	static class Orange {
	}
	
	static void testNoneGenerics() {
		ArrayList apples = new ArrayList();
		apples.add(new Apple());
		apples.add(new Orange());
		
		for (int i=0; i<apples.size(); i++) {
			 // It will get exception when running
			((Apple)apples.get(i)).sayApple();
		}
	}
	
	static void testGenerics() {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple());
//		apples.add(new Orange()); find error when compiled
		
		for (int i=0; i<apples.size(); i++) {
			// No cast is needed
			apples.get(i).sayApple();
		}
	}

	public static void main(String[] args) {
//		testNoneGenerics();
		testGenerics();
	}

}
