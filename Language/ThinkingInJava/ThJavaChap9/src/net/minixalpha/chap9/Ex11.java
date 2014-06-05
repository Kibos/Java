package net.minixalpha.chap9;

interface Processor {
	  String name();
	  Object process(Object input);
}

class Apply {
	public static void process(Processor p, Object s) {
		System.out.println("Using Processor " + p.name());
	    System.out.println(p.process(s));
	}
}

class FooEx11 {
	public String bar(String str) {
		String str_swap = "";
		int str_len = str.length();
		int i = 0;
		
		for (i = 0; i<str_len - 1; i += 2)  {
			str_swap += str.charAt(i + 1);
			str_swap += str.charAt(i);
		}
		
		if (i == str_len - 1) {
			str_swap += str.charAt(i);
		}
		
		return str_swap;
	}
}

class AdapterFooAdapt implements Processor {
	FooEx11 fooEx11;
	public AdapterFooAdapt(FooEx11 fooEx11) {
		this.fooEx11 = fooEx11;
	}
	 public String name() {
		 return "AdapterFooAdapt";
	 }
	  public Object process(Object input) {
		  return fooEx11.bar((String)input);
	  }
	
}

public class Ex11 {
	public static void main(String[] args) {
		FooEx11 fooEx11 = new FooEx11();
		Apply.process(new AdapterFooAdapt(fooEx11), "012");
		Apply.process(new AdapterFooAdapt(fooEx11), "01");
		Apply.process(new AdapterFooAdapt(fooEx11), "0");
	}
}
