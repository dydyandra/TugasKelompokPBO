package id.ac.its.fp;
	
import java.time.LocalDateTime;

import id.ac.its.fp.obj.Transaction;
import id.ac.its.fp.utility.SaveTransaction;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			loader.setController(new FXMLMainMenuController());
	        loader.setLocation(getClass().getResource("mainMenu.fxml"));
	        Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
