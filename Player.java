package game;

public class Player {
	private String name;
	private char mark;

	public Player(String name, char mark) { //constructor for initializing player with name and mark
		this.name=name;
		this.mark=mark;
	}
	public String getName() {
		return name;
	}
	public char getMark() {
		return mark;
	}
	public String toString() { //return string with name and mark of the player. for example: Pipe(P)
		return String.format("%s(%c)", name,mark);
	}

	
}
