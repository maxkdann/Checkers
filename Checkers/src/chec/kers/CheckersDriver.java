package chec.kers;
import java.util.ArrayList;

public class CheckersDriver {

	public static void main(String[] args) {
		Board board = new Board();
		board.display();
		board.initialize();
		board.display();
		ArrayList<Integer> moves = board.checkMoves(2, 3);
		board.displayMoves(moves);
	}

}
