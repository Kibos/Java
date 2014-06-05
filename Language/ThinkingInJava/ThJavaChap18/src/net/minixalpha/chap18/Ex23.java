package net.minixalpha.chap18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Ex23 {

	static void printCharBuffer(ByteBuffer buff) {
		buff.rewind();
		String encoding = System.getProperty("file.encoding");
		Charset charset = Charset.forName(encoding);
		CharBuffer charBuffer = charset.decode(buff);
		System.out.println(charBuffer);
	}

	public static void main(String[] args) throws IOException {
		FileChannel fc = new FileInputStream("test.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(1024);
		fc.read(buff);
		buff.flip();
		printCharBuffer(buff);
	}
}
