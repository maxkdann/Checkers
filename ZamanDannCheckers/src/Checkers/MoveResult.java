package Checkers;

public class MoveResult {

	private MoveType type;
	
	/**
	 * returns whether the piece is red or blue
	 * @return type
	 */
	public MoveType getType() {
		return type;
	}
	
	private Piece piece;
	
	/**
	 * identify a piece
	 * @return that piece object
	 */
	public Piece getPiece() {
		return piece;
	}
	
	/**
	 * default constructor for if piece is not moved
	 * @param type of piece
	 */
	public MoveResult(MoveType type) {
		this(type, null);
	}
	
	/**
	 * constructor for when piece is moved
	 * @param type of piece
	 * @param piece moving
	 */
	public MoveResult(MoveType type, Piece piece) {
		this.type = type;
		this.piece=piece;
	}
}
