package net.minixalpha.chap14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

class ShowMethods {
	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n"
			+ "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.|native|final");

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods)
					System.out.println(p.matcher(method.toString()).replaceAll(
							""));
				for (Constructor ctor : ctors)
					System.out.println(p.matcher(ctor.toString())
							.replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods) {
//					if (method.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(method.toString())
								.replaceAll(""));
						lines++;
//					}
				}
				for (Constructor ctor : ctors)
					if (ctor.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(ctor.toString())
								.replaceAll(""));
						lines++;
					}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}
}

public class Ex17 {
	static void testCase1() {
		String x = "public java.lang.String java.lang.Object.toString()";
		Pattern p = Pattern.compile("\\w+\\.");
		System.out.println(p.matcher(x).replaceAll(""));
	}

	public static void main(String[] args) {
		ShowMethods showMethods = new ShowMethods();
		args = new String[3];
		args[0] = "net.minixalpha.chap14.ShowMethods";
		args[1] = "ShowMethods";
		showMethods.main(args);

	}

}
