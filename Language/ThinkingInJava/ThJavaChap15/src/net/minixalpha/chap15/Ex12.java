
package net.minixalpha.chap15;

import java.util.Map;


public class Ex12 {
	public static void main(String[] args) {
		Map<Ex11Demo, Integer> map = New.<Ex11Demo, Integer>map();
		Ex11Demo key = new Ex11Demo();
		map.put(key, 3);
		System.out.println(map.get(key));
	}

}
