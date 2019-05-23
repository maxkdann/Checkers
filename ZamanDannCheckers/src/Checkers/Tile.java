package Checkers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
	//create a piece object
	private Piece piece;
	/**
	 * constructor for tile object
	 * @param white to say whether the tile is white or black
	 * @param x location of the tile on the board
	 * @param y location of the tile on the board
	 */
	public Tile(boolean white, int x, int y) {
		//set the width and heaight of the tiles
		setWidth(GraphicsDriver.TILE_SIZE);
		setHeight(GraphicsDriver.TILE_SIZE);
		//move the tiles onto the board
		relocate(x * GraphicsDriver.TILE_SIZE, y * GraphicsDriver.TILE_SIZE);
		//colour them white or black
		setFill(white ? Color.valueOf("#ffffff") : Color.valueOf("#000000"));
	}

	/**
	 * returns true or false depending on if it is occupied by a piece object
	 * @return piece object
	 */
	public boolean hasPiece() {
		return piece != null;
	}
	/**
	 * returns the piece object on that specific tile
	 * @return piece
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * places a piece on the tile
	 * @param piece either blue or red
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
