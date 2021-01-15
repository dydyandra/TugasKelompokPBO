package id.ac.its.fp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Controller implements Initializable {
	
	public void backToMenu(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			Controller controller = new FXMLMainMenuController() ;
			loader.setController(controller);
	        loader.setLocation(getClass().getResource("mainMenu.fxml"));
	        Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
			app.setScene(scene);
			app.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goToChart(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			Controller controller = new FXMLChartController() ;
			loader.setController(controller);
	        loader.setLocation(getClass().getResource("viewChart.fxml"));
	        Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
			app.setScene(scene);
			app.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goToInsert(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			Controller controller = new FXMLInsertDataController() ;
			loader.setController(controller);
	        loader.setLocation(getClass().getResource("insertData.fxml"));
	        Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
			app.setScene(scene);
			app.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract void initialize(URL arg0, ResourceBundle arg1) ;
	
}
