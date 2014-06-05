package net.minixalpha.chap14;

import java.util.ArrayList;
import java.util.List;

import net.minixalpha.chap14.pets.*;
import typeinfo.factory.*;

// see change in Cat


public class Ex15 extends PetCreator {
	
	@Override
	public List<Class<? extends Pet>> types() {
		List<Class<? extends Pet>> list = new ArrayList<Class<? extends Pet>>();
		list.add(new Cat.Factory().create());
		list.add(new Dog.Factory().create());
		return list;
	}

	public static void main(String[] args) {
	}
}
