package net.minixalpha.chap9;

interface Game19 {
	public void play();
}

interface GameFactory19 {
	public Game19 getGame();
}

class CoinToss implements Game19 {
	public void play() {
		System.out.println("CoinToss play");
	}
}

class CoinTossFactory implements GameFactory19 {
	public Game19 getGame() {
		return new CoinToss();
	}
}

class DiceToss implements Game19 {
	public void play() {
		System.out.println("DiceToss play");
	}
}

class DiceTossFactory implements GameFactory19 {
	public Game19 getGame() {
		return new DiceToss();
	}
}

public class Ex19 {

	static void play(GameFactory19 gameFactory19) {
		Game19 game19 = gameFactory19.getGame();
		game19.play();
	}

	public static void main(String[] args) {
		play(new CoinTossFactory());
		play(new DiceTossFactory());
	}

}
