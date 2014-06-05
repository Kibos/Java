package net.minixalpha.chap18;

import java.io.*;
import java.nio.*;

class MappedIO {
	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public void runTest() {
			System.out.print(name + ": ");
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration / 1.0e9);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public abstract void test() throws IOException;
	}

	private static Tester[] tests = { new Tester("allocate") {
		public void test() throws IOException {
			ByteBuffer bb = ByteBuffer.allocate(1024);
			int i = 0;
			while (i++ < bb.limit()) {
				if (bb.get() != 0) {
					System.out.println("nonzero");
				}
			}

			for (int j = 0; j < 40000000; j++) {
				bb.rewind();
				bb.asCharBuffer().put("Hello");
				char c;

				while ((c = bb.getChar()) != 0) {
				}
			}

		}
	}, new Tester("allocateDirect") {
		public void test() throws IOException {

			ByteBuffer bb = ByteBuffer.allocateDirect(1024);
			int i = 0;
			while (i++ < bb.limit()) {
				if (bb.get() != 0) {
					System.out.println("nonzero");
				}
			}

			for (int j = 0; j < 4000000; j++) {
				bb.rewind();
				bb.asCharBuffer().put("Hello");
				char c;

				while ((c = bb.getChar()) != 0) {
				}
			}

		}
	} };

	public static void main(String[] args) {
		for (Tester test : tests)
			test.runTest();
	}
}

public class Ex25 {
	public static void main(String[] args) {

	}
}
