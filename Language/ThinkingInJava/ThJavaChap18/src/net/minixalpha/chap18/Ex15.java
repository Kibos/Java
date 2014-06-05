package net.minixalpha.chap18;

import java.io.*;

public class Ex15 {
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("Data.txt")));
		out.writeDouble(3.14159);
		out.writeUTF("That was pi");
		out.writeDouble(1.41413);
		out.writeUTF("Square root of 2");
		out.writeChar('c');
		out.writeFloat(0.5f);
		out.writeInt(3);
		out.writeLong(3L);
		out.writeShort(1);
		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream("Data.txt")));
		System.out.println(in.readDouble());
		// Only readUTF() will recover the
		// Java-UTF String properly:
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readChar());
		System.out.println(in.readFloat());
		System.out.println(in.readInt());
		System.out.println(in.readLong());
		System.out.println(in.readShort());

	}
}
