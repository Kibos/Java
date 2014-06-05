package net.minixalpha.chap13;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Ex14 {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		
		System.out.println(Arrays.toString(input.split("!!")));
		// Only do the first three:
		System.out.println(Arrays.toString(input.split("!!", 3)));
	}
}
