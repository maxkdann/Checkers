package Checkers;

public class Turn {
	int turn;

	
	public Turn(){
		turn =1;
	}


	public void setTurn() {
		turn++;
	}
	
	public int getTurn() {
		return turn;
	}
}
