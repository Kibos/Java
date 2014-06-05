/**
 * @author minix
 * @Date May 15, 2013 10:30:14 PM
 * @Description
 *		Exercise 14: (1) In Car.java add a service( ) method to Engine and call this method
		in main( ).
 */

package net.minixalpha.chap7;

class Engine {
	  public void start() {}
	  public void rev() {}
	  public void stop() {}
	  public void service() {System.out.println("provide service");}
	}

class Wheel {
  public void inflate(int psi) {}
}

class Window {
  public void rollup() {}
  public void rolldown() {}
}

class Door {
  public Window window = new Window();
  public void open() {}
  public void close() {}
}

class Car {
	  public Engine engine = new Engine();
	  public Wheel[] wheel = new Wheel[4];
	  public Door
	    left = new Door(),
	    right = new Door(); // 2-door
	  public Car() {
	    for(int i = 0; i < 4; i++)
	      wheel[i] = new Wheel();
	  }
}	  
public class Ex14 {
	public static void main(String[] args) {
		Car car = new Car();
		car.engine.service();
	}
}

/**Output:
 * provide service
 */
