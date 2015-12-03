package icecreamshop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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

@SuppressWarnings("unchecked")
public void start(Stage primaryStage) throws Exception{
		
		//create database connection
		dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
		
		primaryStage.setWidth(2200);
		primaryStage.setHeight(800);
		primaryStage.setTitle("Order List");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		
	    MenuBar menuBar = new MenuBar();
	 
	    Menu menu1 = new Menu("Home");
	    Menu menu3 = new Menu("Customer Entry");
	    Menu menu4 = new Menu("Place Order");
	    
	    menuBar.getMenus().add(menu1);
	    menuBar.getMenus().add(menu3);
	    menuBar.getMenus().add(menu4);
	    
	    VBox formHolder = new VBox();
	    formHolder.setAlignment(Pos.CENTER);
	    
	    Text title = new Text("Order List");
	    
	  //create new table view
	  		TableView<Order> orderTable = new TableView<>();
	  	
	  		//create columns to display database information by key in database from table
	  		TableColumn<Order, String> order_id_col = new TableColumn<>("Order ID");
	  		order_id_col.setMinWidth(300);
	  		order_id_col.setCellValueFactory(new PropertyValueFactory<>("orderID"));
	  		
	  		TableColumn<Order, String> cone_type_col = new TableColumn<>("Cone Type");
	  		cone_type_col.setMinWidth(300);
	  		cone_type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
	  		
	  		TableColumn<Order, String> cust_id_col = new TableColumn<>("Customer ID");
	  		cust_id_col.setMinWidth(300);
	  		cust_id_col.setCellValueFactory(new PropertyValueFactory<>("custID"));
	  		
	  		TableColumn<Order, String> flavor_col = new TableColumn<>("Flavor");
	  		flavor_col.setMinWidth(300);
	  		flavor_col.setCellValueFactory(new PropertyValueFactory<>("flavor"));
	  		
	  		TableColumn<Order, String> scoops_col = new TableColumn<>("# of Scoops");
	  		scoops_col.setMinWidth(300);
	  		scoops_col.setCellValueFactory(new PropertyValueFactory<>("numScoops"));
	  		
	  		TableColumn<Order, String> status_col = new TableColumn<>("Status");
	  		status_col.setMinWidth(300);
	  		status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
	  	
	  		orderTable.getColumns().addAll(order_id_col, cone_type_col,cust_id_col,flavor_col,flavor_col,scoops_col,status_col);
	  		
	  		orderTable.getItems().addAll(dbaseConnection.getOrders());
	  		
	  		formHolder.getChildren().addAll(title, orderTable);
	  		
	  		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		  	root.setTop(menuBar);
		  	root.setCenter(orderTable);
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
