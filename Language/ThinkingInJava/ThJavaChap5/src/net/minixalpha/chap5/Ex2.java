/**
 * @author minix
 * Apr 3, 2013 2:47:53 PM
 * @description
 *		Exercise 2: (2) Create a class with a String field that is initialized at the point of
 *		definition, and another one that is initialized by the constructor. What is the difference
 *		between the two approaches?

 */

package net.minixalpha.chap5;

class TestMemberInit{
	String initWhenCreate = "create";
	String initWhenConstruct;
	
	public TestMemberInit() {
		initWhenConstruct = "construct";
	}
}

public class Ex2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestMemberInit init = new TestMemberInit();
		System.out.println(init.initWhenCreate);
		System.out.println(init.initWhenConstruct);
	}
}

/**
Output:
create
construct
*/

/**
Explanation:
a String field that is initialized at the point of definition
will be a default value although you do not initialize it in
the constructor.
*/