
package net.minixalpha.chap9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

class GenChars {
	public String gen() {
		return "asdlkfjqor";
	}
}


class AdapterGenCharsToScanner extends GenChars
implements Readable {
	int count;
	
	public AdapterGenCharsToScanner(int m_count) {
		this.count = m_count;
	}
	
	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0) {
			return -1;
		}
		
		String gen_str = gen();
		cb.append(gen_str);
		cb.append("\n");
		return gen_str.length();
	}
}


public class Ex16 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new AdapterGenCharsToScanner(10));
		
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}
}
