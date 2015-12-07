package icecreamshop;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlaceOrder extends Application {
	
	private DBConnect dbaseConnection;

public void start(Stage primaryStage) throws Exception{
		
		//create database connection
		dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
		
		primaryStage.setWidth(1200);
		primaryStage.setHeight(800);
		primaryStage.setTitle("Place an Order");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 350);
		primaryStage.setScene(scene);
	    
		//create vbox to contain form
	    VBox formHolder = new VBox();
	    formHolder.setAlignment(Pos.CENTER);
	    
	    Text title = new Text("Place an Order");
	    
	    //text fields to get user input
	    TextField custID = new TextField();
	    custID.setPromptText("Customer ID");
	    custID.setMaxWidth(400);
	    TextField type = new TextField();
	    type.setPromptText("Cone Type:");
	    type.setMaxWidth(400);
	    TextField flavor = new TextField();
	    flavor.setPromptText("Flavor:");
	    flavor.setMaxWidth(400);
	    Text scoops = new Text("Number of Scoops:");
	    TextField num_scoops = new TextField();
	    num_scoops.setPromptText("Enter a value between 1 and 3");
	    num_scoops.setMaxWidth(400);
	    
        //area where error/success messages will be displayed
        Text displayTotal = new Text("");
        
        //hbox to contain buttons
	    HBox btns = new HBox();
	    btns.setAlignment(Pos.CENTER);
	    
	    Button btnSubmit = new Button("Submit");
	    
	    //on submit, the values from the form will be assigned variables
	    //the variables will be tested for validity before being passed to the placeOrder method
	    //tests for valid number of scoops, customer ID, etc
	    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {	     
	        @Override public void handle(ActionEvent e) {
	        	String thiscustID = custID.getText();
	        	String thisType = type.getText();
	        	String thisFlavor = flavor.getText();
	        	int thisScoops = Integer.parseInt(num_scoops.getText());
	        	
	        	if (thisScoops != 1 || thisScoops != 2 || thisScoops != 3){
	        		displayTotal.setFill(Color.RED);
	        		displayTotal.setText("** Number of scoops must be between one and three **");
	        	}
	        	
	        	try {

	        		int inputNumber = Integer.parseInt(custID.getText());

	        		} catch (NumberFormatException exc) {
	        			displayTotal.setFill(Color.RED);
		        		displayTotal.setText("** Customer ID must be a number, please try again **");
	        		}
	        	
	        	
	        	if (thisScoops == 1 || thisScoops == 2 || thisScoops == 3) {
	        		
	        	double total = (Integer.parseInt(num_scoops.getText()) * .5 + .75);
	        	
	        	try {
					dbaseConnection.placeOrder(thiscustID, thisType, thisFlavor, thisScoops, total);
					if (dbaseConnection.placeOrder(thiscustID, thisType, thisFlavor, thisScoops, total) == 0) {
						displayTotal.setText("** Customer already has an order. Please try again. **");
						custID.clear();
					} else {
						displayTotal.setText("Your order total is: " + total + "\nOrder played successfully.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        	
	        	}
	        	}
	});
	    
	    Button btnClear = new Button("Clear");
	    
	    //on action, this button clears all of the fields
	    btnClear.setOnAction(new EventHandler<ActionEvent>() { 
	        @Override public void handle(ActionEvent e) {
	        	custID.clear();
	        	flavor.clear();
	        	type.clear();
	        	num_scoops.clear();
	        	displayTotal.setText("");
	        }
	    });
	    	    
	    //set margins for better spacing
	    VBox.setMargin(title, new Insets(20,20,20,20));
	    VBox.setMargin(custID, new Insets(20,20,20,20));
	    VBox.setMargin(flavor, new Insets(20,20,20,20));
	    VBox.setMargin(type, new Insets(20,20,20,20));
	    VBox.setMargin(num_scoops, new Insets(20,20,20,20));
	    VBox.setMargin(displayTotal, new Insets(20,20,20,20));
	    HBox.setMargin(btnSubmit, new Insets(20,20,20,20));
	    HBox.setMargin(btnClear, new Insets(20,20,20,20));
	    
	    //add various elements to the containers
	    btns.getChildren().addAll(btnSubmit, btnClear);
	    formHolder.getChildren().addAll(title, custID, flavor, type, scoops, num_scoops, displayTotal, btns);
	    
	  	root.setCenter(formHolder);
	    primaryStage.show();
		
}

public void closeDbase() throws Exception{

	if (dbaseConnection != null){
		dbaseConnection.shutdown();
	}
}

public static void main(String[] args){

	launch(args);
}


}