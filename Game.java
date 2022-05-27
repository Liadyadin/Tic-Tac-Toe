package game;

import java.util.Scanner;

public class Game extends Board {

	protected Player[] players; // players array
	protected Scanner s = new Scanner(System.in); // for input standard

	public Game(int n, int m, Player p1, Player p2) { // initializing the board and the players
		super(n, m); // constructor of Board Class
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
	}

	protected boolean doesWin(int i, int j) { // if last move is win return true. else return false
		if (i == 0 && j == 0)
			return true;
		return false;
	}

	protected boolean onePlay(Player p) { // input player moving and return true if this is the winning move
		System.out.format("%s, please enter x and y:", p.toString()); // input row and col
		int x = s.nextInt();
		int y = s.nextInt();
		while ((super.isEmpty(x, y)) == false) { // if the place is not empty we need new input
			System.out.println("There is a piece there already...");
			System.out.format("%s, please enter x and y:", p.toString());
			x = s.nextInt();
			y = s.nextInt();
		}
		super.set(x, y, p); // insert this player in (x,y)
		System.out.format(super.toString());
		if (doesWin(x, y)) { // checking if this is the winning move
			System.out.format("%s Won!", p.toString());
			return true;
		}
		return false;

	}

	public Player play() { // this is the play moving of 2 players
		while (super.isFull() == false) {// checking if the board is full
			if (onePlay(players[0])) {
				s.close();
				return players[0];
			}
			if (super.isFull() == false)
				if (onePlay(players[1])) {
					s.close();
					return players[1];
				}
		}
		return null;
	}

}
