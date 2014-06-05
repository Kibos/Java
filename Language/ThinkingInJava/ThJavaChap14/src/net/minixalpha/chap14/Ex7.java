package net.minixalpha.chap14;

class Candy {
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Cookie");
	}
}

class SweetShop {
	public static void main(String[] args) {
		try {
			Class.forName("net.minixalpha.chap14." + args[1]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

public class Ex7 {
	public static void main(String[] args) {
		SweetShop sweetShop = new SweetShop();
		args = new String[2];
		args[0] = "Ex7";
		args[1] = "Cookie";
		sweetShop.main(args);
	}
}
