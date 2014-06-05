package net.minixalpha.chap18;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class Ex24 {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		DoubleBuffer ib = bb.asDoubleBuffer();
		// Store an array of int:
		ib.put(new double[] { 2.3, 5.1, 4.7, 3.1 });
		// Absolute location read and write:
		System.out.println(ib.get(3));
		ib.put(3, 1.8);
		// Setting a new limit before rewinding the buffer.
		ib.flip();
		while (ib.hasRemaining()) {
			double i = ib.get();
			System.out.println(i);
		}
	}
}
