package chec.kers;

public class CheckersDriver {

	public static void main(String[] args) {
		Board board = new Board();
		board.display();
		board.initialize();
		board.display();
	}

}
