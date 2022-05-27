package game;

public class Board {

	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) { // constructor to create a play board (nXm)
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}

	protected boolean set(int i, int j, Player p) { // return true- if the place is empty and insert this player and
													// false if the place is full
		if (isEmpty(i, j)) {
			board[i][j] = p;
			return true;
		}
		return false;
	}

	public boolean isEmpty(int i, int j) { // return true- if the place is empty and false-else
		if (board[i][j] == null)
			return true;
		return false;
	}

	public Player get(int i, int j) { // if the place is empty - return null. else return pointer for the player that
										// catch this place
		if (isEmpty(i, j))
			return null;
		return board[i][j];
	}

	public boolean isFull() { // checking if the bourd is full and return true - if not return false
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				if (board[i][j] == null)
					return false;
		return true;

	}

	public String toString() { // A play boarding in string output
		String s = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (isEmpty(i, j))
					s += "."; // if the place is empty
				else
					s += board[i][j].getMark();
			}
			s += "\n";
		}
		return s;
	}

	protected int maxLineContaining(int i, int j) { // return the length of the longest line in the board
		int max = 0, temp;
		for (int dx = -1; dx <= 1; dx++)
			for (int dy = -1; dy <= 1; dy++)
				if ((dx != 0) || (dy != 0)) // (0,0) is this point
					if ((temp = rayLength(i, j, dx, dy)) > max) { // checking the max line for one direction
						max = temp;
						temp = rayLength(i, j, (dx * (-1)), (dy * (-1)));
						max+=temp;
						max--;
					}
		return max;
	}

	private int rayLength(int x, int y, int dx, int dy) { // function for helping calculate maxLineContaining
		int tempx = x;
		int tempy = y;
		int cnt = 0;
		while ((isEmpty(tempx, tempy) == false) && (board[x][y] == board[tempx][tempy])) { // we need 2 points that
																							// equals
			cnt++;
			tempx += dx;
			tempy += dy;
			if (tempx < 0 || tempx > n - 1 || tempy < 0 || tempy > m - 1) // checking domain of the line
				return cnt;
		}
		return cnt;
	}

}
