package net.minixalpha.chap11;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex8 {

	public static void main(String[] args) {
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		gerbils.add(new Gerbil(93));
		gerbils.add(new Gerbil(103));

		Iterator<Gerbil> iterator = gerbils.iterator();
		while (iterator.hasNext()) {
			Gerbil gerbil = iterator.next();
			gerbil.hop();
		}

	}

}
