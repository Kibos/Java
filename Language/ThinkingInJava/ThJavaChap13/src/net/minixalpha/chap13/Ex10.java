package net.minixalpha.chap13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex10 {

	public static void main(String[] args) {
		String str = "Java now has regular expressions";
		String[] regexs = { "^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*",
				"s+", "s{4}", "s{1}.", "s{0,3}" };

		for (String re : regexs) {
			Pattern p = Pattern.compile(re);
			Matcher m = p.matcher(str);
			System.out.println(re);
			while (m.find()) {
				System.out.println(m.group() + " " + m.start() + ":" + m.end());
			}
			System.out.println("---");
		}
	}

}
