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
			dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*primaryStage.setWidth(1200);
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
	    //tests for valid number of scoops, customer ID, etc*/
		
	
		
	    submit.setOnAction(new EventHandler<ActionEvent>() {	     
	        @Override public void handle(ActionEvent e) {
	        	String thiscustID = customerID.getText();
	        	String thisType = coneType.getText();
	        	String thisFlavor = flavor.getText();
	        	int thisScoops = Integer.parseInt(numOfScoops.getText());
	        	
	        	if (thisScoops != 1 || thisScoops != 2 || thisScoops != 3){
	        		displayTotal.setFill(Color.RED);
	        		displayTotal.setText("** Number of scoops must be between one and three **");
	        	}
	        	
	        	try {

	        		int inputNumber = Integer.parseInt(customerID.getText());

	        		} catch (NumberFormatException exc) {
	        			displayTotal.setFill(Color.RED);
		        		displayTotal.setText("** Customer ID must be a number, please try again **");
	        		}
	        	
	        	
	        	if (thisScoops == 1 || thisScoops == 2 || thisScoops == 3) {
	        		
	        	double total = (Integer.parseInt(numOfScoops.getText()) * .5 + .75);
	        	
					dbaseConnection.placeOrder(thiscustID, thisType, thisFlavor, thisScoops, total);
					displayTotal.setText("Your order total is: " + total + "\nOrder placed successfully.");
					}
	        	
	        	}
	 
	        	}
	        
	});
	    
	 //   Button btnClear = new Button("Clear");
	    
	    //on action, this button clears all of the fields
	    clear.setOnAction(new EventHandler<ActionEvent>() { 
	        @Override public void handle(ActionEvent e) {
	        	customerID.clear();
	        	flavor.clear();
	        	coneType.clear();
	        	numOfScoops.clear();
	        	displayTotal.setText("");
	        	Main.scenes.ShowSelectionStage();
	        }
	    });
	    
	    btn_Import.setOnAction(new EventHandler<ActionEvent>() { 
	        @Override public void handle(ActionEvent e) {
	        	customerID.clear();
	        	flavor.clear();
	        	coneType.clear();
	        	numOfScoops.clear();
	        	displayTotal.setText("");
	        	customerID.setText(Main.scenes.getCustomerID());
	        }
	    });
	    	    
	    //set margins for better spacing
	/* VBox.setMargin(title, new Insets(20,20,20,20));
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
	    primaryStage.show();*/
		
}
	


public void closeDbase() throws Exception{

	if (dbaseConnection != null){
		dbaseConnection.shutdown();
	}
}




	



}