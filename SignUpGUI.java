package icecreamshop;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Scene;


public class SignUpGUI implements Initializable{
	
	private DBConnect dbaseConnection;


public void closeDbase() throws Exception{

	if (dbaseConnection != null){
		dbaseConnection.shutdown();
	}
}


@Override
public void initialize(URL location, ResourceBundle resources) {
	//create database connection
			try {
				dbaseConnection = new DBConnect("jdbc:mysql://localhost:3306/icecream", "root", "csc4500");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			//TODO/**gonna have to put all of this in the controller class that is opening it.*/
			/*primaryStage.setWidth(1200);
			primaryStage.setHeight(800);
			primaryStage.setTitle();*/
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 600, 350);
			//primaryStage.setScene(scene);
			
		    MenuBar menuBar = new MenuBar();
		 
		    Menu menu1 = new Menu("Home");
		    Menu menu3 = new Menu("Customer Entry");
		    Menu menu4 = new Menu("Place Order");
		    
		    menuBar.getMenus().add(menu1);
		    menuBar.getMenus().add(menu3);
		    menuBar.getMenus().add(menu4);
		    
		    VBox formHolder = new VBox();
		    formHolder.setAlignment(Pos.CENTER);
		    
		    Text title = new Text("New Customer Information");
		    
		    TextField fName = new TextField();
		    fName.setPromptText("First Name:");
		    fName.setMaxWidth(400);
		    TextField lName = new TextField();
		    lName.setPromptText("Last Name:");
		    lName.setMaxWidth(400);
		    TextField fave = new TextField();
		    fave.setPromptText("Favorite Flavor:");
		    fave.setMaxWidth(400);
		    HBox btns = new HBox();
		    btns.setAlignment(Pos.CENTER);
		    
		    Label status = new Label("");
		    
		    Button btnSubmit = new Button("Submit");
		    
		    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {	     
		        @Override public void handle(ActionEvent e) {
		        	String thisFirstName = fName.getText();
		        	String thisLastName = lName.getText();
		        	String thisFave = fave.getText();
		        	
		        	try {
						dbaseConnection.insert(thisFirstName, thisLastName, thisFave);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
		        	
		        	status.setText("Customer Entered Successfully");
					
		        }
		    });
		    
		    Button btnClear = new Button("Clear");
		    
		    btnClear.setOnAction(new EventHandler<ActionEvent>() { 
		        @Override public void handle(ActionEvent e) {
		        	fName.clear();
		        	lName.clear();
		        	fave.clear();
		        }
		    });
		    	    
		    VBox.setMargin(title, new Insets(20,20,20,20));
		    VBox.setMargin(fName, new Insets(20,20,20,20));
		    VBox.setMargin(fave, new Insets(20,20,20,20));
		    VBox.setMargin(lName, new Insets(20,20,20,20));
		    
		    HBox.setMargin(btnSubmit, new Insets(20,20,20,20));
		    HBox.setMargin(btnClear, new Insets(20,20,20,20));
		    
		    btns.getChildren().addAll(btnSubmit, btnClear);
		    formHolder.getChildren().addAll(title, fName, lName, fave, btns);
		    
		  	//menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		    menuBar.prefWidthProperty().bind(Main.scenes.stage.widthProperty());
		  	root.setTop(menuBar);
		  	root.setCenter(formHolder);
		   // primaryStage.show();
		    
		    Main.scenes.showScene(scene, "Customer Information Entry");
	
}
}