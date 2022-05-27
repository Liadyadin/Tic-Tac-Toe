package game;

public class TicTacToe extends Game {

	public TicTacToe(String player1, String player2) { // constructor for initializing this play

		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));

	}

	@Override
	protected boolean doesWin(int x, int y) { // override if the max line is 3 we have a winner
		if (maxLineContaining(x, y) == 3)
			return true;
		return false;
	}

}
