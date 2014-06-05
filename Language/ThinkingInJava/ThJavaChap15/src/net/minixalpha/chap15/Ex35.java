package net.minixalpha.chap15;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Coffee {

}

class Latte extends Coffee {

}

class Breve extends Coffee {

}

public class Ex35 {
	static void oldStyleCode(List coffeesList) {
		coffeesList.add(new Breve());
	}

	public static void main(String[] args) {
		List<Latte> lattes = new ArrayList<Latte>();
		oldStyleCode(lattes);

		List<Latte> checkedLattes = Collections.checkedList(
				new ArrayList<Latte>(), Latte.class);
		oldStyleCode(checkedLattes); // throw exception

		List<Coffee> list = Collections.checkedList(new ArrayList<Coffee>(),
				Coffee.class);
		list.add(new Latte());
		list.add(new Breve());
	}
}
