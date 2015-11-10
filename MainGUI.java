package icecreamshop;

import java.util.Hashtable;

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
	static int WIDTH_OF_SCENE = 600;
	static int HEIGHT_OF_SCENE = 300;
	

	
	public static void main(String[] args) 
	{
		Customer abby = new Customer("Abby","Art","Acorn");
		Customer bob = new Customer("Bob","Bailman","Bubblegum");
		Customer cal = new Customer("Cal","Cantrop","Caramel");
		Customer derek = new Customer("Derek","Dittmer","Dracula");
		Customer eric = new Customer("Eric","Ehrlich","Eclaire");
		Customer fred = new Customer("Fred","Figaro","Fresh Mint");
		Customer george = new Customer("George","Georgeson","Green Tea");
		Customer herbert = new Customer("Herbert","Harl","Honey");
		Customer ingrid = new Customer("Ingrid","Igne","Ice");
		
		Customer [][] customer = {{abby, bob, cal},{derek, eric, fred},{george,herbert,ingrid}};
		
		for(int i = 0; i < customer.length; i++)
		{
			for(int j = 0; j< customer[0].length; j++)
			{
				
				System.out.println("Customer: " + customer[i][j].getFirstName() );
			}
		}
		
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

