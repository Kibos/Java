package net.minixalpha.chap10;

//: interfaces/HorrorShow.java
//Extending an interface with inheritance.

interface Monster {
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace() {
	}

	public void destroy() {
	}
}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {
	public void menace() {
	}

	public void destroy() {
	}

	public void kill() {
	}

	public void drinkBlood() {
	}
}

class HorrorShow {
	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	static void w(Lethal l) {
		l.kill();
	}

	public static void main(String[] args) {
		DangerousMonster barney = new DangerousMonster() {

			@Override
			public void menace() {

			}

			@Override
			public void destroy() {

			}
		};
		u(barney);
		v(barney);

		Vampire vlad = new Vampire() {

			@Override
			public void kill() {
				// TODO Auto-generated method stub

			}

			@Override
			public void menace() {
				// TODO Auto-generated method stub

			}

			@Override
			public void destroy() {
				// TODO Auto-generated method stub

			}

			@Override
			public void drinkBlood() {
				// TODO Auto-generated method stub

			}
		};
		u(vlad);
		v(vlad);
		w(vlad);
	}
} // /:~

public class Ex14 {

	public static void main(String[] args) {

	}

}
