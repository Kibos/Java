/**
 * @author minix
 * @Date May 12, 2013 5:50:15 PM
 * @Description
 *		Exercise 6: (1) Using Chess.java, prove the statements in the previous paragraph.

 */

package net.minixalpha.chap7;

import static net.mindview.util.Print.*;

class Game {
  Game(int i) {
    print("Game constructor");
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    print("BoardGame constructor");
  }
}	

class Chess extends BoardGame {
  Chess() {
//    super(11); this comment will result in compile error:
//	  implicit super constructor BoardGame() is undefined. Must explicitly invoke another constructor
	super(11);
    print("Chess constructor");
//    super(11); this statement will result in compile error:
 //		Constructor call must be the first statement in a constructor
}
  public static void main(String[] args) {
    Chess x = new Chess();
  }
}

public class Ex6 {
	public static void main(String[] args) {

	}

}
