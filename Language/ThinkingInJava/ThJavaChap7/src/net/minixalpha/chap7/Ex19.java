/**
 * @author minix
 * @Date Jun 10, 2013 10:11:07 PM
 * @Description
 *		Create a class with a blank final reference to an object. Perform the
		initialization of the blank final inside all constructors. Demonstrate the guarantee that the
		final must be initialized before use, and that it cannot be changed once initialized
 */

package net.minixalpha.chap7;

class BlankFinal {
	
}

// Compile error
//class TestBF {
//	final BlankFinal bf;
//}

// Yes!
class TestBF {
	final BlankFinal bf = null;
}

// Yes!
class TestBF2 {
	final BlankFinal bf;
	
	TestBF2() {
		bf = null;
	}
}


//No!
//class TestBF2 {
//	final BlankFinal bf;
//	
//	TestBF2() {
//		bf = null;
//	}
//	
//	TestBF2(int x) {
//		
//	}
//}

class TestBF3 {
	final BlankFinal bf;
	
	TestBF3() {
		bf = null;
	}
	
	TestBF3(int x) {
		bf = null;
	}
}

public class Ex19 {
	public static void main(String[] args) {
		
	}
}
