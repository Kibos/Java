/**
 * Exercise 9: (2) Write a program that demonstrates that autoboxing works for all the
 * primitive types and their wrappers.
 */
package net.minixalpha.chap2;

/**
 * @author minix
 *
 */
public class Ex9 {
	Boolean wrpboolean = false;
	Character wrpchar = 'w';
	Byte wrpbyte = 1;
	Short wrpshort = 2;
	Integer wrpint = 3;
	Long wrplong = 4L;
	Float wrpfloat = 5.6F;
	Double wrpdouble = 7.8;
	Void wrpvoid = null;
	
	public String toString() {
		return wrpboolean + " " + wrpchar + " " + 
			   wrpbyte + " " + wrpint + " " + 
			   wrplong + " " + wrpfloat + " " +
			   wrpdouble + " " + wrpvoid;
	}

}
