/**
 * @author minix
 * @Date Apr 4, 2013 2:07:53 PM
 * @Description
 *		Exercise 5: (2) Create a class called Dog with an overloaded bark( ) method. This
 *		method should be overloaded based on various primitive data types, and print different types
 *		of barking, howling, etc., depending on which overloaded version is called. Write a main( )
 *		that calls all the different versions.

 */

package net.minixalpha.chap5;

class Dog {
	void bark(int i) {
		System.out.println("Bark int: " + i);
	}
	
	void bark(char c) {
		System.out.println("Bark char: " + c);
	}
	
	void bark(String str) {
		System.out.println("Bark string: " + str);
	}
}

public class Ex5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.bark(1);
		dog.bark('x');
		dog.bark("hawl");
	}
}

/*
Output:
Bark int: 1
Bark char: x
Bark string: hawl
*/