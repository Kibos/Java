/**
 * @minix
 * @Date May 11, 2013 2:00:32 PM
 * @Desciption
		Exercise 2: (2) Inherit a new class from class Detergent. Override scrub( ) and add a
		new method called sterilize( )
 */
package net.minixalpha.chap7;

import static net.mindview.util.Print.*;
class Cleanser {
	  private String s = "Cleanser";
	  public void append(String a) { s += a; }
	  public void dilute() { append(" dilute()"); }
	  public void apply() { append(" apply()"); }
	  public void scrub() { append(" scrub()"); }
	  public String toString() { return s; }
	  
	  public static void main(String[] args) {
	    Cleanser x = new Cleanser();
	    x.dilute(); x.apply(); x.scrub();
	    print(x);
	  }
	}	

	class Detergent extends Cleanser {
	  // Change a method:
	  public void scrub() {
	    append(" Detergent.scrub()");
	    super.scrub(); // Call base-class version
	  }
	  // Add methods to the interface:
	  public void foam() { append(" foam()"); }
	  // Test the new class:
	  public static void main(String[] args) {
	    Detergent x = new Detergent();
	    x.dilute();
	    x.apply();
	    x.scrub();
	    x.foam();
	    print(x);
	    print("Testing base class:");
	    Cleanser.main(args);
	  }	
	} 


public class Ex2 extends Detergent{
	 public void scrub() {
		    append(" Ex2.scrub()");
		    super.scrub(); // Call base-class version
	}
	 
	public void sterilize() {
		append(" sterilize");
	}
	 
	public static void main(String[] args) {
		Ex2 ex2 = new Ex2();
		ex2.dilute();
		ex2.apply();
		ex2.scrub();
		ex2.foam();
		ex2.sterilize();
		print(ex2);
	}
}

/**Output:
Cleanser dilute() apply() Ex2.scrub() Detergent.scrub() scrub() foam() sterilize
*/