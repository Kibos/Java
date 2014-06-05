package net.minixalpha.chap9;

interface inter1Ex15 {
	public void foo();

	public void bar();
}

interface inter2Ex15 {
	public void foo2();

	public void bar2();
}

interface inter3Ex15 {
	public void foo3();

	public void bar3();
}

interface inter4Ex15 extends inter1Ex15, inter2Ex15, inter3Ex15 {
	public void foo4();
}

abstract class TestAbstractInterEx15 implements inter4Ex15 {

	@Override
	public void foo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void foo2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bar2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void foo3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bar3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void foo4() {
		// TODO Auto-generated method stub

	}

}

class TestInterEx15 extends TestAbstractInterEx15 {
	@Override
	public void foo4() {
		// TODO Auto-generated method stub

	}
}

public class Ex15 {

	static void u(inter1Ex15 e) {

	}

	static void v(inter2Ex15 e) {

	}

	static void w(inter3Ex15 e) {

	}

	static void x(inter4Ex15 e) {

	}

	public static void main(String[] args) {
		TestInterEx15 testInterEx15 = new TestInterEx15();
		u(testInterEx15);
		v(testInterEx15);
		w(testInterEx15);
		x(testInterEx15);
	}

}
