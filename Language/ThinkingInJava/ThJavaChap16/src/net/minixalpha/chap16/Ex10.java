
package net.minixalpha.chap16;

import java.util.*;

class BerylliumSphere {}

class ArrayOfGenerics {
	  public static void main(String[] args) {
	    List<List<String>> ls = new ArrayList<List<String>>();
	    List<List<String>> la = new ArrayList<List<String>>(10);
	    ls = la; // "Unchecked" warning
	    ls.set(0, new ArrayList<String>());
	    // Compile-time checking produces an error:
	    //! ls[1] = new ArrayList<Integer>();

	    // The problem: List<String> is a subtype of Object
//	    List<Object> objects = ls; ****************************************
	    // Compiles and runs without complaint:
//	    objects.set(1, new ArrayList<Integer>());

	    // However, if your needs are straightforward it is
	    // possible to create an array of generics, albeit
	    // with an "unchecked" warning:
	    
	    List< List<BerylliumSphere>> spheres = new ArrayList<List<BerylliumSphere>>();
	    for(int i = 0; i < spheres.size(); i++)
	      spheres.set(i, new ArrayList<BerylliumSphere>());
	  }
	} 

public class Ex10 {

}
