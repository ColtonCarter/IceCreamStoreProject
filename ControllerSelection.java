package icecreamshop;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerSelection 
implements Initializable {

	@FXML
	public Button btn_Menu;
	@FXML
	public Button btn_Info;
 
	
	
    


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) 
    {
    	

        
    	btn_Menu.setOnAction(new EventHandler<ActionEvent>() 
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            	
            	System.out.println("show menu");
            	Main.scenes.ShowMenu();     
            	System.out.println("show menu comp");
            	
            }
        });
    	
    	btn_Info.setOnAction(new EventHandler<ActionEvent>() 
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            	System.out.println("show cust info");
            	Main.scenes.ShowCustomerInfo();
            	
            	          
            }
        });
        }
   

	

}
