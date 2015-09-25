package icecreamshop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MainGUI extends Application 
{
	//The following two variables are the width and height of our window
	static int WIDTH_OF_SCENE = 300;
	static int HEIGHT_OF_SCENE = 250;
	

	
	public static void main(String[] args) 
	{
		launch(args);
	}

	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("Little Shop of Ice Cream");
		Button btn = new Button();
		btn.setText("Do you want some ice cream?");

		//this is just to create a popup
		Label popupText = new Label("Well to bad we're not open!");
		final Popup popup = new Popup();
		popup.getContent().add(popupText);
		
		
		btn.setOnAction(new EventHandler<ActionEvent>() 
		{
			
			public void handle(ActionEvent event) 
			{
				popup.show(primaryStage);
				
				
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, WIDTH_OF_SCENE, HEIGHT_OF_SCENE));
		primaryStage.show();
	}
}

