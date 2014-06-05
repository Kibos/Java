
package net.minixalpha.chap10;

class FooEx2 {
	String bar;
	
	public FooEx2(String m_bar) {
		this.bar = m_bar;
	}
	
	public String toString() {
		return bar;
	}
}

public class Ex2 {

	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		sequence.add(new FooEx2("bar1"));
		sequence.add(new FooEx2("bar2"));
		
		Selector selector = sequence.selector();
		while (selector.end() == false) {
			System.out.println(selector.current());
			selector.next();
		}
	}

}
