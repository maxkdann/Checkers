package chec.kers;

import chec.kers.CellState;

public class Cell {
	
	private CellState state;
	
	public Cell(CellState cs) {
		state = cs;
		
	}
	
	/**
	 * sets the state of the cell
	 * @param cs
	 */
	public void setState (CellState cs){
		state = cs;
	}
	
	/**
	 * returns the state of the cell selected
	 * @return state
	 */
	public CellState getState() {
		
		return state;
	}
	
	/**
	 * tostring method for debugging
	 */
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
		case HIGHLIGHTED:
			return "_";
		default:
			return "-";
		}
	}
	
	
}
