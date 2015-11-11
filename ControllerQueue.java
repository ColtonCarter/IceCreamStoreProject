package icecreamshop;

import java.util.ResourceBundle;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tableView.AU_DBaseConnect;
import tableView.AU_emp;


public class ControllerQueue implements Initializable {

	@FXML
	public Button btn_Complete; 
	
	@FXML
	public TableView<Order> tblView_orders; 
	
	@FXML 
	public TableColumn<Order, String> col_orderNum;
	
	@FXML 
	public TableColumn<Order, String> col_type;
	
	@FXML 
	public TableColumn<Order, String> col_name;
	
	@FXML 
	public TableColumn<Order, String> col_flavor;
	
	@FXML 
	public TableColumn<Order, String> col_numScoops;
	
	@FXML 
	public TableColumn<Order, String> col_status;
 
	private DBConnect dbaseConnection;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) 
    {
    	
    	
    	//create database connection
    	dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
    	
    	//create columns to display database information by key in database from table
    			col_orderNum.setMinWidth(300);
    			col_orderNum.setCellValueFactory(new PropertyValueFactory<>("order_num"));
    			
    			col_name.setMinWidth(300);
    			col_name.setCellValueFactory(new PropertyValueFactory<>("customerID"));
    			
    			col_type.setMinWidth(300);
    			col_type.setCellValueFactory(new PropertyValueFactory<>("cone_type"));
    			
    			col_flavor.setMinWidth(300);
    			col_flavor.setCellValueFactory(new PropertyValueFactory<>("cone_flavor"));
    			
    			col_numScoops.setMinWidth(300);
    			col_numScoops.setCellValueFactory(new PropertyValueFactory<>("numScoops"));
    			
    			col_status.setMinWidth(300);
    			col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
    		
    			tblView_orders.getColumns().addAll(col_orderNum, col_name, col_type, col_flavor, col_numScoops, col_status);
    		
    			tblView_orders.getItems().addAll(dbaseConnection.getOrders());

    	

        
    //	btn_LogOn.setOnAction(new EventHandler<ActionEvent>() 
     //   {
        	
        //    @Override
        //    public void handle(ActionEvent event) 
     //       {
            	
          //  	LoadScene("Log in", new Stage(), "LogOn.fxml", 640, 480);
            	          
        //    }
     //   });
        }
    
    public void LoadScene(String newTitle, Stage primaryStage, String fxmlName, int width, int height)
	{
		try {
			
			Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlName));
	        Scene scene = new Scene(newRoot, width, height);
	        
	        primaryStage.setTitle(newTitle);
	        primaryStage.setScene(scene);

	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
