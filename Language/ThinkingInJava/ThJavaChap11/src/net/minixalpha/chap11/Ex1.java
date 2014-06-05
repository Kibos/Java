package net.minixalpha.chap11;

import java.util.ArrayList;

class Gerbil {
	private int gerbilNumber;
	
	public Gerbil(int gerbiNumber) {
		this.gerbilNumber = gerbiNumber;
	}
	
	public void hop() {
		System.out.println("Hopping " + gerbilNumber);
	}
}

public class Ex1 {
	
	public static void main(String[] args) {
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		gerbils.add(new Gerbil(93));
		gerbils.add(new Gerbil(103));
		
		for (Gerbil gerbil: gerbils) {
			gerbil.hop();
		}
		
	}

}
