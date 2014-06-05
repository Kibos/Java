package net.minixalpha.thjava.textbook.chap2;

public class CreateClass {
	
	int testVarOfMember;
	
	public String toString() {
		return "My Name is CreateClass";
	}
	
	public int getTestVarOfMember() {
		return this.testVarOfMember;
	}
	
	public int getTestVarOfLocal() {
		int i = 0;
		// int i; 如果不初始化，Java会给出编译错误
		return i;
	}
	
	public void testMethods(int num) {
		System.out.println(num);
	}
	
	// 函数名和参数是一个方法的唯一标识，不能只通过返回值来区分两个方法
//	public int testMethods(int num) {
//		return num;
//	}
}
