package net.minixalpha.chap18;

import java.io.*;

public class Ex16 {
	static String file = "rtest.dat";

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		rf.writeChar('c');
		rf.writeInt(3);
		rf.writeLong(4L);
		rf.writeShort(5);
		rf.writeFloat(0.4f);
		rf.writeDouble(0.9);
		rf.writeUTF("sdf");
		rf.close();

		rf = new RandomAccessFile(file, "r");
		System.out.println(rf.readChar());
		System.out.println(rf.readInt());
		System.out.println(rf.readLong());
		System.out.println(rf.readShort());
		System.out.println(rf.readFloat());
		System.out.println(rf.readDouble());
		System.out.println(rf.readUTF());
		rf.close();
	}
}
