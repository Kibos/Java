
package net.minixalpha.chap12;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		List<Integer> list = null;
		try {
			list.add(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
