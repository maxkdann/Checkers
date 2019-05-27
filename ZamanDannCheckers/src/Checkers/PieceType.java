package Checkers;

public enum PieceType {
	// blue pieces will be positive as their y locations will increase
	// red pieces will be the oppostie
	BLUE(1), RED(-1), RKING(1, -1), BKING(1, -1);
	//move direction will be positive or negative based on the piece type
	final int moveDir;
	final int moveDir1;
	PieceType(int moveDir) {
		this.moveDir = moveDir;
		this.moveDir1 = 0;
	}
	
	PieceType(int moveDir, int moveDir1) {
		this.moveDir = moveDir;
		this.moveDir1 = moveDir1;

	}
}
