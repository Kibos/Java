/**
 * @author minix
 * @Date May 13, 2013 11:55:40 PM
 * @Description
 *		Exercise 11: (3) Modify Detergent.java so that it uses delegation.

 */

package net.minixalpha.chap7;

import static net.mindview.util.Print.*;

class Cleanserx {
  private String s = "Cleanser";
  public void append(String a) { s += a; }
  public void dilute() { append(" dilute()"); }
  public void apply() { append(" apply()"); }
  public void scrub() { append(" scrub()"); }
  public String toString() { return s; }
  public static void main(String[] args) {
    Cleanserx x = new Cleanserx();
    x.dilute(); x.apply(); x.scrub();
    print(x);
  }
}	

class Detergentx {
  Cleanserx cleaner = new Cleanserx();
  // Change a method:
  public void scrub() {
	cleaner.append(" Detergent.scrub()");
	cleaner.scrub(); // Call base-class version
  }
  // Add methods to the interface:
  public void foam() { cleaner.append(" foam()"); }
  // Test the new class:
  public static void main(String[] args) {
    Detergentx x = new Detergentx();
    x.scrub();
    x.foam();
    print(x);
    print("Testing base class:");
    Cleanserx.main(args);
  }	
} 

public class Ex11 {
	public static void main(String[] args) {
		 Detergentx x = new Detergentx();
		    x.scrub();
		    x.foam();
		    print(x);
		    print("Testing base class:");
		    Cleanserx.main(args);
	}
}

/**Output:
net.minixalpha.thjava.exercise.chap7.Detergentx@aea8cf
Testing base class:
Cleanser dilute() apply() scrub()
*/
