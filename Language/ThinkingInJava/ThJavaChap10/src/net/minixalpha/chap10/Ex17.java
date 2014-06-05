package net.minixalpha.chap10;

interface Game19 {
	public void play();
}

interface GameFactory19 {
	public Game19 getGame();
}

class CoinToss implements Game19 {
	public static GameFactory19 factory = new GameFactory19() {

		@Override
		public Game19 getGame() {
			return new CoinToss();
		}
	};

	public void play() {
		System.out.println("CoinToss play");
	}
}

class DiceToss implements Game19 {
	public static GameFactory19 factory = new GameFactory19() {

		@Override
		public Game19 getGame() {
			return new DiceToss();
		}
	};

	public void play() {
		System.out.println("DiceToss play");
	}
}

public class Ex17 {

	static void play(GameFactory19 gameFactory19) {
		Game19 game19 = gameFactory19.getGame();
		game19.play();
	}

	public static void main(String[] args) {
		play(CoinToss.factory);
		play(DiceToss.factory);
	}

}
