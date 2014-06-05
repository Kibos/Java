/**
 * 文件名：MainLoader.java
 * 功能：调用各个类方法
 */
package net.minixalpha.thjava.textbook.chap1;

/**
 * @author zhaoxk
 * @version 0.0
 * @date 2013-03-22
 */
public class MainLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.draw();
		
		Circle circle = new Circle();
		circle.draw();
		
		Triangle triangle = new Triangle();
		triangle.draw();
		
		Shape circleShape = new Circle();
		circleShape.draw();
		
		Shape triangleShape = new Triangle();
		triangleShape.draw();
		
	}

}
