/**
 * @minix
 * @Date May 9, 2013 6:58:10 PM
 * @Desciption
 *		Exercise 8: (4) Following the form of the example Lunch.java, create a class called
		ConnectionManager that manages a fixed array of Connection objects. The client
		programmer must not be able to explicitly create Connection objects, but can only get them
		via a static method in ConnectionManager. When the ConnectionManager runs out of
		objects, it returns a null reference. Test the classes in main( )
 */
package net.minixalpha.chap6;

class ConnectionManager {
	private ConnectionManager() {}
	static int num = 3;
	static ConnectionManager[] cm = new ConnectionManager[num];
	static  {
		for(int i=0; i<num; i++) {
			cm[i] = new ConnectionManager();
		}
	}
	static ConnectionManager accessObj() {
		if (num <= 0) return null;
		num --;
		return cm[num];
	}
}

public class Ex8 {
	public static void main(String[] args) {
		ConnectionManager cm = ConnectionManager.accessObj();
		while (cm != null) {
			System.out.println("new ConnectionManager");
			cm = ConnectionManager.accessObj();
		}
	}
}
