package net.minixalpha.chap15;

class CoffeeEx38 {
	public CoffeeEx38() {
	}
}

class DecoratorEx38 extends CoffeeEx38 {
	public DecoratorEx38(CoffeeEx38 coffee) {
	}
}

class MilkDecoratorEx38 extends DecoratorEx38 {

	public MilkDecoratorEx38(CoffeeEx38 coffee) {
		super(coffee);
	}

	public void sayMilk() {
		System.out.println("saymilk");
	}
}

class ChocolateDecoratorEx38 extends DecoratorEx38 {

	public ChocolateDecoratorEx38(CoffeeEx38 coffee) {
		super(coffee);
	}

	public void sayCoffee() {
		System.out.println("sayCoffee");
	}
}

public class Ex38 {

}
