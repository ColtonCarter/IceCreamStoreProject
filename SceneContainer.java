package icecreamshop;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

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
    
    String customerID;

    SceneContainer() 
    {
    	customerID = "";
    	
    	stage = new Stage();
    	
    	try {
			logOnRoot = FXMLLoader.load(getClass().getResource("LogOn.fxml"));
		} catch (IOException e) {
			System.out.println("LogOnNotLoaded");
			e.printStackTrace();
		}
        logOnScene = new Scene(logOnRoot, 750, 600);
        
        try {
			SelectionRoot = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
		} catch (IOException e) {
			System.out.println("SelectionScreenNotLoaded");
			e.printStackTrace();
		}
        SelectionScene = new Scene(SelectionRoot, 750, 600);
        
        try {
			MenuRoot = FXMLLoader.load(getClass().getResource("placeorder.fxml"));
		} catch (IOException e) {
			System.out.println("MenuNotLoaded");
			e.printStackTrace();
		}
        MenuScene = new Scene(MenuRoot, 750, 600);
        
        try {
			CustomerInfoRoot = FXMLLoader.load(getClass().getResource("CustomerInfo.fxml"));
		} catch (IOException e) {
			System.out.println("CustomerInfoNotLoaded");
			e.printStackTrace();
		}
        CustomerInfoScene = new Scene(CustomerInfoRoot, 750, 600);
        
        try {
			QueueRoot = FXMLLoader.load(getClass().getResource("OrderQueue.fxml"));
		} catch (IOException e) {
			System.out.println("QueueNotLoaded");
			e.printStackTrace();
		}
        QueueScene = new Scene(QueueRoot, 750, 600);
        
        
    }
    
    public void showScene(Scene scene, String title) //Brittany, try calling Main.scenes.showScene(scene, title) in your code, 
    												//you will have to remove all of your primaryStage calls and use this function
    												//instead of primaryStage.show();
    {
    	stage.setScene(scene);
    	stage.setTitle(title);
    	stage.show();
    }
    
    public void setCustomerID(String cID)
    {
    	this.customerID = cID;
    }
    
    public String getCustomerID()
    {
    	return this.customerID;
    }
    
    public void ShowLogOnStage()
    {
        stage.setTitle("LogOn");
        stage.setScene(logOnScene);
        stage.show();

       
    }
    public void ShowSelectionStage()
    {
    	stage.setTitle("SelectionScreen");
        stage.setScene(SelectionScene);
        stage.show();
        
    }
    
    public void ShowCustomerInfo()
    {
    	stage.setTitle("CustomerInfo");
        stage.setScene(CustomerInfoScene);
        stage.show();
    }
    
    public void ShowMenu()
    {
    	stage.setTitle("Place Order");
        stage.setScene(MenuScene);
        stage.show();
    }
    
    public void ShowQueue()
    {
    	stage.setTitle("OrderQueue");
        stage.setScene(QueueScene);
        stage.show();
    }
    
 


}
