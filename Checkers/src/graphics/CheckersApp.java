package graphics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CheckersApp extends Application {

	public static final int tileSize = 100;
	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;

	private Group tileGroup = new Group();
	private Group pieceGroup = new Group();

	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH * tileSize, HEIGHT * tileSize);
		root.getChildren().addAll(tileGroup, pieceGroup);

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				Tile tile = new Tile((x + y) % 2 == 0, x, y);

				tileGroup.getChildren().add(tile);
			}
		}
		return root;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("Checkers");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

}
