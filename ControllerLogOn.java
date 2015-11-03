package application;

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

public class ControllerLogOn implements Initializable {

	@FXML
	public Button btn_Submit; 
 
	
	
    


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) 
    {
    	

        
    	btn_Submit.setOnAction(new EventHandler<ActionEvent>() 
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            	
            	LoadScene("Select", new Stage(), "SelectionScreen.fxml", 640, 480);
            	          
            }
        });
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
