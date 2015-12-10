package icecreamshop;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class PlaceOrder  implements Initializable {
	
	private DBConnect dbaseConnection;
	
	@FXML 
	public TextField customerID;
	
	@FXML 
	public TextField flavor;
	
	@FXML 
	public TextField coneType;
	
	@FXML 
	public TextField numOfScoops;
	
	@FXML 
	public Button submit;
	
	@FXML 
	public Button clear;
	
	@FXML 
	public Text displayTotal;
	
	@FXML 
	public Button btn_Import;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//create database connection
		try {
			dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		//grabs field input and assigns them variables
	    submit.setOnAction(new EventHandler<ActionEvent>() {	     
	        @Override public void handle(ActionEvent e) {
	        	String thiscustID = customerID.getText();
	        	String thisType = coneType.getText();
	        	String thisFlavor = flavor.getText();
	        	int thisScoops = Integer.parseInt(numOfScoops.getText());
	        	
	        	//makes sure they dont order more than 3 scoops
	        	if (thisScoops != 1 || thisScoops != 2 || thisScoops != 3){
	        		displayTotal.setFill(Color.RED);
	        		displayTotal.setText("** Number of scoops must be between one and three **");
	        	}
	        	
	        	try {

	        		int inputNumber = Integer.parseInt(customerID.getText());
	        		//makes sure customer id is an integer
	        		} catch (NumberFormatException exc) {
	        			displayTotal.setFill(Color.RED);
		        		displayTotal.setText("** Customer ID must be a number, please try again **");
	        		}
	        	
	        	
	        	if (thisScoops == 1 || thisScoops == 2 || thisScoops == 3) {
	        		
	        	double total = (Integer.parseInt(numOfScoops.getText()) * .5 + .75);
	        	
					try {
						//counts to see if the customer has less than ten cones
						//if so, it places the order. if not, it gives this error message
						int numOrders = dbaseConnection.countOrders(thiscustID);
						if (numOrders < 10){
						dbaseConnection.placeOrder(thiscustID, thisType, thisFlavor, thisScoops, total);
						displayTotal.setText("Your order total is: " + total + "\nOrder placed successfully.");
						} else {
							displayTotal.setText("Sorry!\nThis customer has reached the maximum of 10 cone orders.");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					}
	        	customerID.clear();
	        	flavor.clear();
	        	coneType.clear();
	        	numOfScoops.clear();
	        	displayTotal.setText("");
	        	Main.scenes.ShowSelectionStage();
	        	
	        	}
	 
	        	});
	    
	    //on action, this button clears all of the fields
	    clear.setOnAction(new EventHandler<ActionEvent>() { 
	        @Override public void handle(ActionEvent e) {
	        	customerID.clear();
	        	flavor.clear();
	        	coneType.clear();
	        	numOfScoops.clear();
	        	displayTotal.setText("");
	        	
	        }
	    });
	    
	    btn_Import.setOnAction(new EventHandler<ActionEvent>() { 
	        @Override public void handle(ActionEvent e) {
	        	customerID.clear();
	        	flavor.clear();
	        	coneType.clear();
	        	numOfScoops.clear();
	        	displayTotal.setText("");
	        	//calls method to populate ID stored in temp class
	        	customerID.setText(Main.scenes.getCustomerID());
	        }
	    });
		
}
	


public void closeDbase() throws Exception{

	if (dbaseConnection != null){
		dbaseConnection.shutdown();
	}
}




	



}