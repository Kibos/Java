/**
 * 此文件用于单元测试
 */
package net.minixalpha.chap1;

import net.minixalpha.thjava.textbook.chap1.*;
import junit.framework.TestCase;

/**
 * @author zhaoxk
 *
 */
public class ShapeTest extends TestCase {
	
	 Shape shape;
	 Circle circle;
	 Triangle triangle;
	 Shape circleShape;
	 Shape triangleShape;
	
	//此方法在执行每一个测试方法之前（测试用例）之前调用
	protected void setUp() throws Exception {
		super.setUp();
		shape = new Shape();
		circle = new Circle();
		triangle = new Triangle();
		circleShape = new Circle();
		triangleShape = new Triangle();
		System.out.println("SetUp()");
	}
	
	//此方法在执行每一个测试方法之后调用
	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("tearDown()");
	}
	
	public void testShape() {
		assertEquals("I am a Shape", shape.draw());
	}
	
	public void testCircle() {
		assertEquals("I am a Circle", circle.draw());
	}
	
	public void testCircleShape() {
		assertEquals("I am a Shape", circleShape.draw());
	}
	
	public void testTriangleShape() {
		assertEquals("I am a Shape", triangleShape.draw());
	}
	
}
