package chec.kers;
import java.util.ArrayList;

public class CheckersDriver {

	public static void main(String[] args) {
		Board board = new Board();
		board.display();
		board.initialize();
		board.display();
		board.movePiece(CellState.P1, 5, 0, 4, 1);
		board.display();
		board.movePiece(CellState.P2, 2, 3, 3, 2);
		board.display();
	}

}
