package chec.kers;

import javafx.scene.control.Button;

public class NewButton extends Button {
	private int row;
	private int col;
	
	public NewButton (int r, int c){
		super();
		row = r;
		col = c;
	}
	
	/**
	 * get the row of the button selected
	 * @return row
	 */
	public int getRow(){
		return row;
	}
	/**
	 * get the column of the button selected
	 * @return column
	 */
	public int getCol(){
		return col;
	}
	
	/**
	 * returns the location of the button
	 */
	@Override
	public String toString(){
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol())+"]";
	}
}
