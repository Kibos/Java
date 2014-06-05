
package net.minixalpha.chap13;

class InfiniteRecursion {
	public String toString() {
		return " InfiniteRecursion address: " + super.toString();
	}
}


public class Ex2 {

	public static void main(String[] args) {
		System.out.println(new InfiniteRecursion());
	}

}
