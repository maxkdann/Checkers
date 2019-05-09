package graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{

	private Piece piece;
	
	public boolean hasPiece() {
		return piece!=null;
	}
	
	public Tile(boolean light, int x, int y) {
		setWidth(x*CheckersApp.tileSize);
		setHeight(CheckersApp.tileSize);
		
		relocate(x*CheckersApp.tileSize,y*CheckersApp.tileSize);
		//set the colours of light and dark tiles
		setFill(light ? Color.valueOf("#feb"):Color.valueOf("582"));
	}
}
