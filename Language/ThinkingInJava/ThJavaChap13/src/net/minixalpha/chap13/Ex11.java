
package net.minixalpha.chap13;
public class Ex11 {

	public static void main(String[] args) {
		String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
		String str = "Arline ate eight apples and one orange while Anita hadn’t any";
		System.out.println(str.matches(regex));
	}

}
