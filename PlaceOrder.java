package icecreamshop;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlaceOrder extends Application {
	
	private DBConnect dbaseConnection;

@SuppressWarnings({ "rawtypes", "unchecked" })
public void start(Stage primaryStage) throws Exception{
		
		//create database connection
		dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
		
		primaryStage.setWidth(1200);
		primaryStage.setHeight(800);
		primaryStage.setTitle("Place an Order");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 350);
		primaryStage.setScene(scene);
		
	    MenuBar menuBar = new MenuBar();
	 
	    Menu menu1 = new Menu("Home");
	    Menu menu3 = new Menu("Customer Entry");
	    Menu menu4 = new Menu("Place Order");
	    Menu menu5 = new Menu("View Orders");
	    
	    menuBar.getMenus().add(menu1);
	    menuBar.getMenus().add(menu3);
	    menuBar.getMenus().add(menu4);
	    menuBar.getMenus().add(menu5);
	    
	    VBox formHolder = new VBox();
	    formHolder.setAlignment(Pos.CENTER);
	    
	    Text title = new Text("Place an Order");
	    
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
	    final ComboBox num_scoops = new ComboBox();
        num_scoops.getItems().addAll(
            "1", "2", "3"
        );  
        
        Text displayTotal = new Text("");
        
	    HBox btns = new HBox();
	    btns.setAlignment(Pos.CENTER);
	    
	    Button btnSubmit = new Button("Submit");
	    
	    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {	     
	        @Override public void handle(ActionEvent e) {
	        	String thiscustID = custID.getText();
	        	String thisType = type.getText();
	        	String thisFlavor = flavor.getText();
	        	int thisScoops = (int) num_scoops.getValue();
	        	double total = ((int)num_scoops.getValue() * .5);
	        	
	        	try {
					dbaseConnection.placeOrder(thiscustID, thisType, thisFlavor, thisScoops, total);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        	
	        	displayTotal.setText("Your order total is: " + total + "\nOrder played successfully.");
				
	        }
	    });
	    
	    Button btnClear = new Button("Clear");
	    
	    btnClear.setOnAction(new EventHandler<ActionEvent>() { 
	        @Override public void handle(ActionEvent e) {
	        	custID.clear();
	        	flavor.clear();
	        	type.clear();
	        }
	    });
	    	    
	    VBox.setMargin(title, new Insets(20,20,20,20));
	    VBox.setMargin(custID, new Insets(20,20,20,20));
	    VBox.setMargin(flavor, new Insets(20,20,20,20));
	    VBox.setMargin(type, new Insets(20,20,20,20));
	    VBox.setMargin(num_scoops, new Insets(20,20,20,20));
	    VBox.setMargin(displayTotal, new Insets(20,20,20,20));
	    HBox.setMargin(btnSubmit, new Insets(20,20,20,20));
	    HBox.setMargin(btnClear, new Insets(20,20,20,20));
	    
	    btns.getChildren().addAll(btnSubmit, btnClear);
	    formHolder.getChildren().addAll(title, custID, flavor, type, scoops, num_scoops, btns);
	    
	  	menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	  	root.setTop(menuBar);
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