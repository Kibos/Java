package net.minixalpha.chap16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Ex23 {

	public static void main(String[] args) {
		Random rand = new Random();
		Integer[] ints = new Integer[10];

		for (int i = 0; i < ints.length; i++) {
			ints[i] = rand.nextInt(20);
		}

		System.out.println(Arrays.toString(ints));

		Arrays.sort(ints, Collections.reverseOrder());

		System.out.println(Arrays.toString(ints));
	}

}
