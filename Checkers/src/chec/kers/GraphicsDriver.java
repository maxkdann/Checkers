package chec.kers;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javafx.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GraphicsDriver extends Application {
	private static final double BUTTON_WIDTH = 60;
	private static final double BUTTON_HEIGHT = 60;
	public NewButton[][] slots = new NewButton[8][8];
	public static Board board = new Board();
	final Image p1 = new Image(getClass().getResourceAsStream("redpiece30px.png"));
	final Image p2 = new Image(getClass().getResourceAsStream("bluepiece35px.png"));
	Stage window;
	int turn = 1;



	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final double WIDTH = 1600;
		final double HEIGHT = 900;
		board.initialize();
		window = primaryStage;
		window.setTitle("Welcome to Checkers");
		
		window.setScene(welcome(primaryStage, WIDTH, HEIGHT));
		window.show();
	}

	/**
	 * Welcome menu scene, gets user's choice
	 * @param window (stage)
	 * @param width of the stage
	 * @param height of the stage
	 * @return the scene
	 */
	public Scene welcome(Stage window, double width, double height) {		
		final Image titleScreen = new Image("asset.jpg"); // title screen image
		final ImageView flashScreen_node = new ImageView();
		flashScreen_node.setImage(titleScreen); // set the image of the title screen
		window.getIcons().add(titleScreen); // stage icon
		Label label = new Label("Please choose one of the following: ");
		HBox hbox = new HBox();
		Button button2 = new Button("Start");
		 Button roundButton = new Button();

	        roundButton.setStyle(
	                "-fx-background-radius: 5em; " +
	                "-fx-min-width: 30px; " +
	                "-fx-min-height: 30px; " +
	                "-fx-max-width: 30px; " +
	                "-fx-max-height: 30px;" +
	                "-fx-color: FF0000"
	        );

		button2.setOnAction(e -> {
			boolean result = ConfirmBox.display("Verify", "Are you sure you're ready to start?");
			if (result) {
				// 2 players
				System.out.println("2 players");
				window.setScene(initBoard());
				window.show();
			}
		});
		HBox buttons = new HBox();
		buttons.getChildren().addAll(button2, roundButton);
		buttons.setAlignment(Pos.CENTER);
		VBox layout = new VBox();
		layout.getChildren().addAll(label,buttons);
		layout.setAlignment(Pos.CENTER);
		StackPane root = new StackPane();
		root.getChildren().addAll(flashScreen_node, layout);
		Scene scene = new Scene(root, width, height, Color.BLACK);
		return scene;
	}
	
	public Scene initBoard() {
		GridPane gridPane = new GridPane();		
		Scene checkersBoard = new Scene(gridPane,900,900);	
		gridPane.setAlignment(Pos.CENTER);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				slots[i][j] = new NewButton(i,j);
				slots[i][j].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
				if (board.getState(i, j) == CellState.PLAY) {
					slots[i][j].setDisable(true);
					slots[i][j].setStyle("-fx-base: #ffffff;");
				}else if(board.getState(i, j) == CellState.P2) {
					slots[i][j].setGraphic(new ImageView(p2));
				}else if(board.getState(i, j) == CellState.P1){
					slots[i][j].setGraphic(new ImageView(p1));
				}else {
					slots[i][j].setMouseTransparent(true);
					slots[i][j].setStyle("-fx-base: #000000;");

				}

				slots[i][j].setOnAction((event) -> { 
					
					System.out.println( ((NewButton) event.getSource()).getRow() + ", " + ((NewButton) event.getSource()).getCol() ); 
				
					
				});
			}
		}
		
		game();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				gridPane.add(slots[i][j], j,i+1);
			}
		}
		
		return checkersBoard;
	}
	
	public void game() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(turn%2 != 0) {
					if(board.getState(i, j) == CellState.P2) {
						slots[i][j].setDisable(true);
						
					}
					slots[i][j].setOnAction((event) -> { 
						ArrayList<Integer> moves = board.checkMoves(((NewButton) event.getSource()).getRow(), ((NewButton) event.getSource()).getCol());
						if(moves.get(0).equals(null)) {
							
						}else if(moves.get(2).equals(null)){
							board.setState(moves.get(0), moves.get(1), CellState.HIGHLIGHTED);
						}else {
							board.setState(moves.get(3), moves.get(2), CellState.HIGHLIGHTED);
							board.setState(moves.get(1), moves.get(0), CellState.HIGHLIGHTED);
						}
						
						updateBoard(board, slots);
						
					});
				}else {
					if(board.getState(i, j) == CellState.P1) {
							slots[i][j].setDisable(true);
					}
				}
			}
		}
		
		turn++;
	}
	
	public void updateBoard(Board board, NewButton[][] slots) {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				switch (board.getState(i, j)) {
				case PLAY:
					slots[i][j].setDisable(true);
					slots[i][j].setStyle("-fx-base: #ffffff;");
				case P1:
					slots[i][j].setGraphic(new ImageView(p1));
				case P2:
					slots[i][j].setGraphic(new ImageView(p2));
				case HIGHLIGHTED:
					slots[i][j].setStyle("-fx-base: #ffff00;");
					slots[i][j].setDisable(false);
				default:
					slots[i][j].setMouseTransparent(true);
					slots[i][j].setStyle("-fx-base: #000000;");
				}
			}
		}
	}

}