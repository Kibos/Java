
package net.minixalpha.chap9;

interface RodentForInterface {
	void say();
}

class MouseImpleInterface implements RodentForInterface {
	public void say() {
		System.out.println("MouseImpleInterface");
	}
}

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseImpleInterface mouseImpleInterface = new MouseImpleInterface();
		mouseImpleInterface.say();

	}

}
