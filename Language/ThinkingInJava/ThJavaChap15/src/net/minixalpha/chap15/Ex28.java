package net.minixalpha.chap15;

class Generic1<T> {
	public void foo(T a) {

	}
}

class Generic2<T> {
	public T bar() {
		return null;
	}
}

class Man {
	
}

class Woman extends Man {
	
}

public class Ex28 {
	public static <T>  void foo(Generic1<? super Woman> f) {
		f.foo(null);
	}
	
	public static <T>  void bar(Generic2<? extends Man> f) {
		f.bar();
	}
	
	
	public static void main(String[] args) {
		Generic1<Man> man = new Generic1<Man>();
		foo(man);
		Generic1<Woman> woman = new Generic1<Woman>();
		foo(woman);
		
		Generic2<Man> man2 = new Generic2<>();
		bar(man2);
		Generic2<Woman> woman2 = new Generic2<>();
		bar(woman2);
	}
	
}
