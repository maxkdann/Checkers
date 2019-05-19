package chec.kers;

import java.util.ArrayList;
import chec.kers.CellState;
import chec.kers.Cell;

public class Board {	
	
	private static Cell[][] board;
	CellState NOPLAY = CellState.NOPLAY;
	CellState PLAY = CellState.PLAY;
	
	Board(){
		board = new Cell[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if((i+j)%2==0) {
					board[i][j] = new Cell(NOPLAY);
				}else {
					board[i][j] = new Cell(PLAY);
				}
			}
		}
	}
	
	/**
	 * set up original board
	 */
	public void initialize() {
	  for(int i = 0; i < 8; i++) {
		  for(int j = 0; j<8; j++) {
			  if(i==3 || i==4) {
				  
			  }else if(i<3) {
				  if(board[i][j].getState() == PLAY) {
					  board[i][j].setState(CellState.HIGHLIGHTED.P2);
				  }
			  }else {
				  if(board[i][j].getState() == PLAY) {
					  board[i][j].setState(CellState.P1);
				  }
			  }
		  }
	  }
	}
	
	/**
	 * move the pieces
	 * @param player
	 * @param x possible move location based on arraylist of moves
	 * @param y possible move location based on arraylist of moves
	 * @param w possible move location based on arraylist of moves
	 * @param z possible move location based on arraylist of moves
	 */
	public void movePiece(CellState player, int x, int y, int w, int z) {
		board[x][y].setState(PLAY);
		if(w == x-2 && z == y-2) {
			board[w][z].setState(player);
			board[x-1][y-1].setState(PLAY);
		}
		
		if(w == x-2 && z == y+2) {
			board[w][z].setState(player);
			board[x-1][y+1].setState(PLAY);
		}
		
		if(w == x+2 && z == y+2) {
			board[w][z].setState(player);
			board[x+1][y+1].setState(PLAY);
		}
		
		if(w == x+2 && z == y-2) {
			board[w][z].setState(player);
			board[x+1][y-1].setState(PLAY);
		}
		
		board[w][z].setState(player);
	}
	
	/**
	 * returns a list of possible move locations for a selected piece
	 * @param x location of piece
	 * @param y location of piece
	 * @return possible moves of selected piece
	 */
	public ArrayList<Integer> checkMoves(int x, int y) {
		ArrayList<Integer> moves = new ArrayList<>();
		if(board[x][y].getState() == CellState.P1) {
			if(y==0) {
				if(board[x-1][y+1].getState() == PLAY) {
					moves.add(x-1);
					moves.add(y+1);
					return moves;
				}else {
					if(board[x-2][y+2].getState() == PLAY && x>1 && y<6) {
						moves.add(x-2);
						moves.add(y+2);
						return moves;
					}else {
						return moves;
					}
				}
			}else if(y==7) {
				if(board[x-1][y-1].getState() == PLAY) {
					moves.add(x-1);
					moves.add(y-1);
					return moves;
				}else {
					if(board[x-2][y-2].getState() == PLAY && x>1 && y>1) {
						moves.add(x-2);
						moves.add(y-2);
						return moves;
					}else {
						return moves;
					}
				}
			}else {
				if(board[x-1][y+1].getState() != PLAY) {
					if(board[x-2][y+2].getState() == PLAY && x>1 && y<6) {
						moves.add(x-2);
						moves.add(y+2);
					}
				}
				
				if(board[x-1][y-1].getState() != PLAY) {
					if(board[x-2][y-2].getState() == PLAY && x>1 && y>1) {
						moves.add(x-2);
						moves.add(y-2);
					}
				}
				
				if(board[x-1][y+1].getState() == PLAY) {
					moves.add(x-1);
					moves.add(y+1);
				}
				
				if(board[x-1][y-1].getState() == PLAY) {
					moves.add(x-1);
					moves.add(y-1);
				}
				
				return moves;
			}
			
			
		}else if(board[x][y].getState() == CellState.P2) {
			if(y==0) {
				if(board[x+1][y-1].getState() == PLAY) {
					moves.add(x+1);
					moves.add(y-1);
					return moves;
				}else {
					if(board[x+2][y-2].getState() == PLAY && x<6 && y>1) {
						moves.add(x+2);
						moves.add(y-2);
						return moves;
					}else {
						return moves;
					}
				}
			}else if(y==7) {
				if(board[x+1][y+1].getState() == PLAY) {
					moves.add(x+1);
					moves.add(y+1);
					return moves;
				}else {
					if(board[x+2][y+2].getState() == PLAY && x<6 && y<6) {
						moves.add(x+2);
						moves.add(y+2);
						return moves;
					}else {
						return moves;
					}
				}
			}else {
				if(board[x+1][y-1].getState() != PLAY) {
					if(board[x+2][y-2].getState() == PLAY && x<6 && y>1) {
						moves.add(x+2);
						moves.add(y-2);
					}
				}
				
				if(board[x+1][y+1].getState() != PLAY) {
					if(board[x+2][y+2].getState() == PLAY && x<6 && y<6) {
						moves.add(x+2);
						moves.add(y+2);
					}
				}
				
				if(board[x+1][y-1].getState() == PLAY) {
					moves.add(x+1);
					moves.add(y-1);
				}
				
				if(board[x+1][y+1].getState() == PLAY) {
					moves.add(x+1);
					moves.add(y+1);
				}
				
				return moves;
			}
		}else {
			return moves;
		}
	}
	
	/**
	 * get the state of the tile at a specific location on the board
	 * @param x coordinate of the tile
	 * @param y coordinate of the tile
	 * @return state of the tile
	 */
	public CellState getState(int x, int y) {
		return board[x][y].getState();
	}
	
	/**
	 * set the state of the tile to the desired given state
	 * @param x coordinate of the tile
	 * @param y coordinate of the tile
	 * @param state 
	 */
	public void setState(int x, int y, CellState state) {
		board[x][y].setState(state);
	}
	
	/**
	 * displays a text board for debugging
	 */
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * displays the possible moves of the piece selected
	 * @param moves
	 */
	public void displayMoves(ArrayList<Integer> moves) {
		for(int i = 0; i < moves.size(); i++) {
			System.out.print(moves.get(i));
			System.out.print(", ");
		}
	}

}

