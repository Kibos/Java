package net.minixalpha.chap9;


interface inter1Ex13 {
	public void foo();
}

interface inter2Ex13 extends inter1Ex13 {
	public void bar();
}

interface inter3Ex13 extends inter1Ex13 {
	public void geo();
}

interface inter4Ex13 extends inter2Ex13, inter3Ex13 {
	public void sae();
}

class testInter implements inter4Ex13 {

	@Override
	public void bar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void foo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void geo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sae() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Ex13 {

	public static void main(String[] args) {

	}

}
