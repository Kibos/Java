package net.minixalpha.chap12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LogExp1 extends Exception {
	private static Logger logger = Logger.getLogger("LogExp1");

	public LogExp1() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}

}

class LogExp2 extends Exception {
	private static Logger logger = Logger.getLogger("LogExp2");

	public LogExp2() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class Ex6 {

	public static void main(String[] args) {
		try {
			throw new LogExp1();
		} catch (LogExp1 exp1) {
			System.out.println(exp1);
		}

		try {
			throw new LogExp2();
		} catch (LogExp2 exp2) {
			System.out.println(exp2);
		}
		
		try {
			throw new LogExp1();
		} catch (LogExp1 exp1) {
			System.out.println(exp1);
		}
	}

}
