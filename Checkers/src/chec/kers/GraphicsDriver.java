package chec.kers;

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
import javafx.stage.Stage;

public class GraphicsDriver extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Welcome to Checkers");
		final double CANVAS_WIDTH = 550;
		final double CANVAS_HEIGHT = 550;
		final Image titleScreen = new Image("asset.jpg"); // title screen image
		final ImageView flashScreen_node = new ImageView();
		flashScreen_node.setImage(titleScreen); // set the image of the title screen
		window.getIcons().add(titleScreen); // stage icon
		Label label = new Label("Please choose one of the following: ");
		HBox hbox = new HBox();
		Button button1 = new Button("1 Player");
		Button button2 = new Button("2 Players");
		button1.setOnAction(e -> {
			boolean result = ConfirmBox.display("Verify", "You selected player vs Ai, do you wish to continue?");
			if (result) {
				// ai game
				System.out.println("ai");
			}
		});
		button2.setOnAction(e -> {
			boolean result = ConfirmBox.display("Verify", "You selected player vs player, do you wish to continue?");
			if (result) {
				// 2 players
				System.out.println("2 players");
			}
		});
		HBox buttons = new HBox();
		buttons.getChildren().addAll(button1, button2);
		buttons.setAlignment(Pos.CENTER);
		VBox layout = new VBox();
		layout.getChildren().addAll(label,buttons);
		layout.setAlignment(Pos.CENTER);
		StackPane root = new StackPane();
		root.getChildren().addAll(flashScreen_node, layout);
		Scene scene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT, Color.BLACK);
		window.setScene(scene);
		window.show();
	}

}