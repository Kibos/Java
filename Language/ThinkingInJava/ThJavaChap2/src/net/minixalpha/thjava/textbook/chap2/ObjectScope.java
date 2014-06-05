package net.minixalpha.thjava.textbook.chap2;

public class ObjectScope {

	/**
	 * @param args
	 */
	
	ObjectScope() {
		
	}

	public void testObjectScope() {
		// 测试对象作用域
		String s;
		{
			String t = "abc";
			System.out.printf("%x\n", t.hashCode());
			s = t;
		}
		System.out.printf("%x\n", s.hashCode());
	}

}
