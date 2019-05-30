package Checkers;

public class Turn {
	int turn;

	
	public Turn(){
		turn =1;
	}


	public void incTurn() {
		turn++;
	}
	
	public void setTurn(int newTurn) {
		turn = newTurn;
	}
	
	public int getTurn() {
		return turn;
	}
}
