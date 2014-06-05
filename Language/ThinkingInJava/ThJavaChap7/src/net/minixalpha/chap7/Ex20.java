/**
 * @author minix
 * @Date Jun 10, 2013 10:28:17 PM
 * @Description
 *		Show that @Override annotation solves the problem in this section
 */
package net.minixalpha.chap7;
import static net.mindview.util.Print.*;

class WithFinals {
  // Identical to "private" alone:
  private final void f() { print("WithFinals.f()"); }
  // Also automatically "final":
  private void g() { print("WithFinals.g()"); }
}

class OverridingPrivate extends WithFinals {
  private final void f() {
    print("OverridingPrivate.f()");
  }
  private void g() {
    print("OverridingPrivate.g()");
  }
}

class OverridingPrivate2 extends OverridingPrivate {
	
//	@Override 
//	public final void f() {
//    print("OverridingPrivate2.f()");
//  }
//	@Override 
//  public void g() {
//    print("OverridingPrivate2.g()");
//  }
}

class FinalOverridingIllusion {
  public static void main(String[] args) {
    OverridingPrivate2 op2 = new OverridingPrivate2();
//    op2.f();
//    op2.g();
    // You can upcast:
    OverridingPrivate op = op2;
    // But you can't call the methods:
   // op.f();
    //! op.g();
    // Same here:
    WithFinals wf = op2;
    //! wf.f();
    //! wf.g();
  }
} 

public class Ex20 {
	public static void main(String[] args) {

	}
}
