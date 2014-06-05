//: enumerated/menu/Course.java
package net.minixalpha.chap19;

import net.mindview.util.*;

public enum Course {
	APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), DESSERT(
			Food.Dessert.class), COFFEE(Food.Coffee.class), FRUIT(
			Food.Dessert.class);
	private Food[] values;

	private Course(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}

	public Food randomSelection() {
		return Enums.random(values);
	}
} // /:~
