package chec.kers;

import chec.kers.Cell;

public class Board {	
	
	private static Cell[][] board;

	
	Board(){
		board = new Cell[8][8];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Cell(CellState.P1); // player 1
			}
		}
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
		for (int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Cell(CellState.P2); // player 2
			}
		}
	}
}
