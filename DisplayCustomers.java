package icecreamshop;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DisplayCustomers implements Initializable {
	
	private DBConnect dbaseConnection;
	
	@FXML
	public Button order; 
	
	@FXML
	public TableView<Customer> customer_list; 
	
	@FXML 
	public TableColumn<Customer, String> col_fname;
	
	@FXML 
	public TableColumn<Customer, String> col_lname;
	
	@FXML 
	public TableColumn<Customer, String> col_id;
	
	@FXML 
	public TableColumn<Customer, String> col_flavor;
	
	@FXML 
	public TextField id_input;
	
	@FXML 
	public Label title;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	System.out.println("Initializing display customers");
		
		//create database connection
		try {
			dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//create stage, set size etc
		/*primaryStage.setWidth(1600);
		primaryStage.setHeight(800);
		primaryStage.setTitle("Order List");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
	    
		//create vbox to contain all of the elements
	    VBox formHolder = new VBox();
	    formHolder.setAlignment(Pos.CENTER);
	    
	    Text title = new Text("Order List");
	    */
	  //create new table view
	  		//TableView<Order> orderTable = new TableView<>();
	  	
	  		//create columns to display database information by key in database from table
	  		
	  		/*TableColumn<Order, String> cone_num_col = new TableColumn<>("Order Number");
	  		cone_num_col.setMinWidth(240);*/
	  		col_fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
	  		
	  		/*TableColumn<Order, String> cone_type_col = new TableColumn<>("Cone Type");
	  		cone_type_col.setMinWidth(240);*/
	  		col_lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
	  		
	  	/*	TableColumn<Order, String> flavor_col = new TableColumn<>("Flavor");
	  		flavor_col.setMinWidth(240);*/
	  		col_id.setCellValueFactory(new PropertyValueFactory<>("custID"));
	  		
	  		/*TableColumn<Order, String> scoops_col = new TableColumn<>("# of Scoops");
	  		scoops_col.setMinWidth(240);*/
	  		col_flavor.setCellValueFactory(new PropertyValueFactory<>("flavor"));
	  		
	  		//add columns to table vview
	  		//orderTable.getColumns().addAll(cone_num_col,cone_type_col,flavor_col,scoops_col,status_col,total_col);
	  		//populate information from database
	  		try {
				customer_list.getItems().addAll(dbaseConnection.getCustomers());
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	  		
	  		//Text update_title = new Text("Complete an Order");
	  		
	  		//text field to gather user input of which order to update as complete
		  /*  TextField ordernumber = new TextField();
		    ordernumber.setPromptText("Order #");
		    ordernumber.setMaxWidth(400);*/
		    
		    //hbox to contain buttons
		  /*  HBox buttons = new HBox();
		    buttons.setAlignment(Pos.CENTER);
	  		
	  		Button update = new Button("Update");
	  		Button refresh = new Button("Refresh");
	  		
	  		buttons.getChildren().addAll(update,refresh);*/
	  		
	  		//action event that calls the 'update' method in DBConnect
	  		order.setOnAction(new EventHandler<ActionEvent>() {	     
		        @Override public void handle(ActionEvent e) {
		        	
		        	Main.scenes.setCustomerID(id_input.getText());
		        	id_input.clear();
		        	Main.scenes.ShowMenu();
		        	//store variable in temp class here
		        	//switch to place an order scene
		        	
					
		        }
		    });
	  		
	  		
	  		//add all elements to vbox
	  	/*	formHolder.getChildren().addAll(title, orderTable, update_title, ordernumber, buttons);
	  		VBox.setMargin(title, new Insets(20,20,20,20));
	 	    VBox.setMargin(ordernumber, new Insets(20,20,20,20));
	 	    VBox.setMargin(orderTable, new Insets(20,20,20,20));
	 	    HBox.setMargin(refresh, new Insets(20,20,40,20));
	 	    HBox.setMargin(update, new Insets(20,20,40,20));
	 	    VBox.setMargin(update_title, new Insets(20,20,20,20));
	  		
	  		//set vbox in the center of the scene, show primary stage
		  	root.setCenter(formHolder);
		    primaryStage.show();*/
}

public void closeDbase() throws Exception{

	if (dbaseConnection != null){
		dbaseConnection.shutdown();
	}
}




}
