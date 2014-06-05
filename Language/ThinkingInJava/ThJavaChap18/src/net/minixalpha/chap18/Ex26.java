package net.minixalpha.chap18;

import java.io.File;
import java.io.FileInputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;

public class Ex26 {
	public static void main(String[] args) throws Exception {
		args = new String[2];
		args[0] = "test.txt";
		args[1] = "asdf";
		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1]);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher("");

		FileChannel fc = new FileInputStream(new File(args[0])).getChannel();
		MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
				fc.size());
		Charset charset = Charset.forName("US-ASCII");
		CharsetDecoder decoder = charset.newDecoder();
		CharBuffer charBuffer = decoder.decode(buffer);
		Scanner sc = new Scanner(charBuffer).useDelimiter(System
				.getProperty("line.separator"));
		while (sc.hasNext()) {
			String line = sc.next();
			m.reset(line);
			while (m.find())
				System.out.println(index++ + ": " + m.group() + ": "
						+ m.start());
		}
	}
}
