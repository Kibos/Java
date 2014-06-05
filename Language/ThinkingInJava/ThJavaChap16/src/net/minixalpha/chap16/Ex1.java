package net.minixalpha.chap16;

class Ex1Demo {}

public class Ex1 {
	
	private static void hide(Ex1Demo[] demos) {
		
	}

	public static void main(String[] args) {
		Ex1Demo[] demos = {new Ex1Demo(), new Ex1Demo()};
		Ex1Demo[] demos2;
		
//		demos2 = {new Ex1Demo(), new Ex1Demo()};
		
		hide(demos);
		
//		hide( {new Ex1Demo(), new Ex1Demo()} );
	}

}
