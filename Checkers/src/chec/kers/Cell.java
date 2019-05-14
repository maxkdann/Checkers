package chec.kers;

import chec.kers.CellState;

public class Cell {
	
	private CellState state;
	
	public Cell(CellState cs) {
		state = cs;
		
	}
	
	public void setState (CellState cs){
		state = cs;
	}
	
	public CellState getState() {
		return state;
	}
	
	public String toString() {
		switch (state) {
		case NOPLAY:
			return "X";
		case PLAY:
			return "O";
		case P1:
			return "-";
		case P2:
			return "*";
		default:
			return "-";
		}
	}
}
