package net.minixalpha.chap18;

import java.util.prefs.Preferences;

public class Ex33 {
	public static void main(String[] args) {
		Preferences prefs = Preferences.userNodeForPackage(Ex33.class);
		String baseDir = prefs.get("baseDir", "");
		System.out.println(baseDir);
		prefs.put("baseDir", ".");
		System.out.println(prefs.get("baseDir", ""));
	}
}
