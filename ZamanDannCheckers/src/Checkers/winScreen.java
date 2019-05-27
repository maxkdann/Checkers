package Checkers;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class winScreen {
	
	
	public static void display(String colour) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Winner!");
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(colour+" Wins!");
		
		Button button = new Button("Close");
		
		button.setOnAction(e ->{
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);
		Scene scene =new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		
	}
}
