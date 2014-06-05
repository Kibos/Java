package net.minixalpha.chap12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Ex7 {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("ex7");
		
		try {
			Integer[] ia = { 1, 2 };
			int b = ia[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			logger.severe(trace.toString());
		}

	}
}
