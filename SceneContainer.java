package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneContainer 
{
	Stage stage;
	
	
	AnchorPane logOnRoot;
    Scene logOnScene;
 
    AnchorPane SelectionRoot;
    Scene SelectionScene;
    
    AnchorPane MenuRoot;
    Scene MenuScene;
 
    AnchorPane CustomerInfoRoot;
    Scene CustomerInfoScene;
    
    AnchorPane QueueRoot;
    Scene QueueScene;
    

    SceneContainer() throws IOException
    {
    	stage = new Stage();
    	
    	logOnRoot = FXMLLoader.load(getClass().getResource("LogOn.fxml"));
        logOnScene = new Scene(logOnRoot, 640, 480);
        
        SelectionRoot = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
        SelectionScene = new Scene(SelectionRoot, 640, 480);
        
        MenuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        MenuScene = new Scene(MenuRoot, 640, 480);
        
        CustomerInfoRoot = FXMLLoader.load(getClass().getResource("CustomerInfo.fxml"));
        CustomerInfoScene = new Scene(CustomerInfoRoot, 640, 480);
        
        QueueRoot = FXMLLoader.load(getClass().getResource("OrderQueue.fxml"));
        QueueScene = new Scene(QueueRoot, 640, 480);
        
        
    }
    
    public void showScene(Scene scene, String title) //Brittany, try calling Main.scenes.showScene(scene, title) in your code, 
    												//you will have to remove all of your primaryStage calls and use this function
    												//instead of primaryStage.show();
    {
    	stage.setScene(scene);
    	stage.setTitle(title);
    	stage.show();
    }
    
    public void ShowLogOnStage()
    {
        stage.setTitle("LogOn");
        stage.setScene(logOnScene);
        stage.show();

       
    }
    public void ShowSelectionStage()
    {
    	stage.setTitle("SelectionScreen.fxml");
        stage.setScene(SelectionScene);
    }
    
    public void ShowCustomerInfo()
    {
    	stage.setTitle("CustomerInfo.fxml");
        stage.setScene(CustomerInfoScene);
    }
    
    public void ShowMenu()
    {
    	stage.setTitle("Menu.fxml");
        stage.setScene(MenuScene);
    }
    
    public void ShowQueue()
    {
    	stage.setTitle("OrderQueue.fxml");
        stage.setScene(QueueScene);
    }
    
 


}
