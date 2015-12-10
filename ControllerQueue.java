package icecreamshop;

import java.util.ResourceBundle;

import java.net.URL;
import java.sql.SQLException;


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

public class ControllerQueue implements Initializable {

	@FXML
	public Button btn_Complete; 
	
	@FXML
	public Button btn_Reset; 
	
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
    	
    }
    

}
