
package net.minixalpha.chap12;
public class Ex1 {

	public static void main(String[] args) {
		try {
			throw new Exception("hijack");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("hitom");
		}
	}

}
