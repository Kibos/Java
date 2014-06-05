/**
 * @author 
 * @Date Jun 17, 2013 4:41:34 PM
 * @Description
 * 	Modify Music3.java so that it randomly creates Instrument objects
	the way Shapes.java does

 */
package net.minixalpha.chap8;

import java.util.Random;

public class Ex8 {
	private static Random rand = new Random();
	public static Instrument instruRandomGen() {
		switch (rand.nextInt(3)) {
		case 0:
			return new Wind();
		case 1:
			return new Percussion();
		case 2:
			return new Brass();
		}
		return null;
		
	}
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			System.out.println(instruRandomGen());
		}
	}
}

/**
Output:
Brass
Brass
Brass
Wind
Brass
Percussion
Percussion
Percussion
Percussion
Brass
*/