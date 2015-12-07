package icecreamshop;


import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayOrders extends Application {
	
	private DBConnect dbaseConnection;

public void start(Stage primaryStage) throws Exception{
		
		//create database connection
		dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
		
		//create stage, set size etc
		primaryStage.setWidth(1600);
		primaryStage.setHeight(800);
		primaryStage.setTitle("Order List");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
	    
		//create vbox to contain all of the elements
	    VBox formHolder = new VBox();
	    formHolder.setAlignment(Pos.CENTER);
	    
	    Text title = new Text("Order List");
	    
	  //create new table view
	  		TableView<Order> orderTable = new TableView<>();
	  	
	  		//create columns to display database information by key in database from table
	  		
	  		TableColumn<Order, String> cone_num_col = new TableColumn<>("Order Number");
	  		cone_num_col.setMinWidth(240);
	  		cone_num_col.setCellValueFactory(new PropertyValueFactory<>("num"));
	  		
	  		TableColumn<Order, String> cone_type_col = new TableColumn<>("Cone Type");
	  		cone_type_col.setMinWidth(240);
	  		cone_type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
	  		
	  		TableColumn<Order, String> flavor_col = new TableColumn<>("Flavor");
	  		flavor_col.setMinWidth(240);
	  		flavor_col.setCellValueFactory(new PropertyValueFactory<>("flavor"));
	  		
	  		TableColumn<Order, String> scoops_col = new TableColumn<>("# of Scoops");
	  		scoops_col.setMinWidth(240);
	  		scoops_col.setCellValueFactory(new PropertyValueFactory<>("scoops"));
	  		
	  		TableColumn<Order, String> status_col = new TableColumn<>("Status");
	  		status_col.setMinWidth(240);
	  		status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
	  		
	  		TableColumn<Order, String> total_col = new TableColumn<>("Total");
	  		total_col.setMinWidth(240);
	  		total_col.setCellValueFactory(new PropertyValueFactory<>("total"));
	  	
	  		//add columns to table vview
	  		orderTable.getColumns().addAll(cone_num_col,cone_type_col,flavor_col,scoops_col,status_col,total_col);
	  		//populate information from database
	  		orderTable.getItems().addAll(dbaseConnection.getOrders());
	  		
	  		Text update_title = new Text("Complete an Order");
	  		
	  		//text field to gather user input of which order to update as complete
		    TextField ordernumber = new TextField();
		    ordernumber.setPromptText("Order #");
		    ordernumber.setMaxWidth(400);
		    
		    //hbox to contain buttons
		    HBox buttons = new HBox();
		    buttons.setAlignment(Pos.CENTER);
	  		
	  		Button update = new Button("Update");
	  		Button refresh = new Button("Refresh");
	  		
	  		buttons.getChildren().addAll(update,refresh);
	  		
	  		//action event that calls the 'update' method in DBConnect
	  		update.setOnAction(new EventHandler<ActionEvent>() {	     
		        @Override public void handle(ActionEvent e) {
		        	String field_input = ordernumber.getText();
		        	
		        	try {
						dbaseConnection.update(field_input);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
		        	
					
		        }
		    });
	  		
	  		//clears the items in the table and reloads them, to demonstrate the order has been updated
	  		refresh.setOnAction(new EventHandler<ActionEvent>() {	     
		        @Override public void handle(ActionEvent e) {
		        	 orderTable.getItems().clear();
		        	 ordernumber.clear();
		 	  		try {
						orderTable.getItems().addAll(dbaseConnection.getOrders());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		        }
		    });
	  		
	  		//add all elements to vbox
	  		formHolder.getChildren().addAll(title, orderTable, update_title, ordernumber, buttons);
	  		VBox.setMargin(title, new Insets(20,20,20,20));
	 	    VBox.setMargin(ordernumber, new Insets(20,20,20,20));
	 	    VBox.setMargin(orderTable, new Insets(20,20,20,20));
	 	    HBox.setMargin(refresh, new Insets(20,20,40,20));
	 	    HBox.setMargin(update, new Insets(20,20,40,20));
	 	    VBox.setMargin(update_title, new Insets(20,20,20,20));
	  		
	  		//set vbox in the center of the scene, show primary stage
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
