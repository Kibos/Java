package net.minixalpha.chap15;

import java.util.*;

class Goods {
	Random random = new Random();
	int id = 0;
	
	public Goods(int n) {
		id = random.nextInt(n);
	}

	public String toString() {
		return this.getClass().getSimpleName() + " " + id;
	}
}

class Boat extends ArrayList<Goods> {
	Random random = new Random();
	int id = random.nextInt();
	
	public Boat(int n) {
		for(int i=0; i<n; i++) {
			add(new Goods(n));
		}
	}

	public String toString() {
		return this.getClass().getSimpleName() + " " + id;
	}
}

class Ship extends ArrayList<Boat> {
	Random random = new Random();
	int id = random.nextInt();
	
	public Ship(int nBoad, int nGoods) {
		for(int i=0; i<nBoad; i++) {
			add(new Boat(nGoods));
		}
	}

	public String toString() {
		return this.getClass().getSimpleName() + " " + id;
	}
}

public class Ex19 {
	public static void main(String[] args) {
		Ship ship = new Ship(3, 3);
		for(Boat boat: ship) {
			System.out.println(boat);
			for (Goods goods: boat) {
				System.out.println(goods);
			}
			System.out.println("--");
		}
	}
}
