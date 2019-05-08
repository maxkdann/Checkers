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
}
