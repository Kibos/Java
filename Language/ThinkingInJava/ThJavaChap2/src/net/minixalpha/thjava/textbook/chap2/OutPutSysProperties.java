package net.minixalpha.thjava.textbook.chap2;

public class OutPutSysProperties {
	public static void start() {
		System.out.println(System.getProperty("java.library.path"));
		// list会将前面的结果发送给它的参数
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
	}
}
