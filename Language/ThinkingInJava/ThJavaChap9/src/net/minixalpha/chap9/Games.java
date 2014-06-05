
package net.minixalpha.chap9;

interface Game { 
	boolean move(); 
}

interface GameFactory {
	Game geGame();
}

class Game1 implements Game {
	public boolean move() {
		System.out.println("Game1 move");
		return true;
	}
}

class Game1Factory implements GameFactory {
	@Override
	public Game geGame() {
		return new Game1();
	}
}


class Game2 implements Game {
	public boolean move() {
		System.out.println("Game2 move");
		return true;
	}
}

class Game2Factory implements GameFactory {
	@Override
	public Game geGame() {
		return new Game2();
	}
}

public class Games {
	static void playGame(GameFactory gameFactory) {
		Game game = gameFactory.geGame();
		game.move();
	}
	public static void main(String[] args) {
		playGame(new Game1Factory());
		playGame(new Game2Factory());
	}
}
