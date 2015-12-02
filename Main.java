package icecreamshop;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application 
{
	public static SceneContainer scenes;
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		scenes = new SceneContainer();
		LoadScene("Queue", primaryStage, "OrderQueue.fxml", 640, 480);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	void LoadScene(String newTitle, Stage primaryStage, String fxmlName, int width, int height)
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




