package net.minixalpha.chap9;

interface inter1Ex14 {
	public void foo();

	public void bar();
}

interface inter2Ex14 {
	public void foo2();

	public void bar2();
}

interface inter3Ex14 {
	public void foo3();

	public void bar3();
}

interface inter4Ex14 extends inter1Ex14, inter2Ex14, inter3Ex14 {
	public void foo4();
}

class TestInterEx14 implements inter4Ex14 {

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

public class Ex14 {

	static void u(inter1Ex14 e) {

	}

	static void v(inter2Ex14 e) {

	}

	static void w(inter3Ex14 e) {

	}

	static void x(inter4Ex14 e) {

	}

	public static void main(String[] args) {
		TestInterEx14 testInterEx14 = new TestInterEx14();
		u(testInterEx14);
		v(testInterEx14);
		w(testInterEx14);
		x(testInterEx14);
	}

}
