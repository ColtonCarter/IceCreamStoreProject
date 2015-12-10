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
    
    AnchorPane PlaceOrderRoot;
    Scene PlaceOrderScene;
    

    SceneContainer() 
    {
    	stage = new Stage();
    	
    	try {
			logOnRoot = FXMLLoader.load(getClass().getResource("LogOn.fxml"));
		} catch (IOException e) {
			System.out.println("LogOnNotLoaded");
			e.printStackTrace();
		}
        logOnScene = new Scene(logOnRoot, 640, 480);
        
        try {
			SelectionRoot = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
		} catch (IOException e) {
			System.out.println("SelectionScreenNotLoaded");
			e.printStackTrace();
		}
        SelectionScene = new Scene(SelectionRoot, 640, 480);
        
        try {
			MenuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		} catch (IOException e) {
			System.out.println("MenuNotLoaded");
			e.printStackTrace();
		}
        MenuScene = new Scene(MenuRoot, 640, 480);
        
        try {
			CustomerInfoRoot = FXMLLoader.load(getClass().getResource("CustomerInfo.fxml"));
		} catch (IOException e) {
			System.out.println("CustomerInfoNotLoaded");
			e.printStackTrace();
		}
        CustomerInfoScene = new Scene(CustomerInfoRoot, 640, 480);
        
        try {
			QueueRoot = FXMLLoader.load(getClass().getResource("OrderQueue.fxml"));
		} catch (IOException e) {
			System.out.println("QueueNotLoaded");
			e.printStackTrace();
		}
        QueueScene = new Scene(QueueRoot, 640, 480);
        try {
			PlaceOrderRoot = FXMLLoader.load(getClass().getResource("placeorder.fxml"));
		} catch (IOException e) {
			System.out.println("PlaceOrderNotLoaded");
			e.printStackTrace();
		}
        PlaceOrderScene = new Scene(PlaceOrderRoot, 640, 480);
        
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
    public void ShowPlaceOrder()
    {
    	stage.setTitle("placeorder.fxml");
        stage.setScene(PlaceOrderScene);
    }
    
 


}
