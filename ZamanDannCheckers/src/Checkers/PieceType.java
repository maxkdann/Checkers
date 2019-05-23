package Checkers;

public enum PieceType {
	// blue pieces will be positive as their y locations will increase
	// red pieces will be the oppostie
	BLUE(1), RED(-1);
	//move direction will be positive or negative based on the piece type
	final int moveDir;

	PieceType(int moveDir) {
		this.moveDir = moveDir;
	}
}
