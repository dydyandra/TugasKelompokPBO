package id.ac.its.fp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import id.ac.its.fp.obj.*;

public class FXMLMainMenuController implements Initializable {
	
	@FXML
	private Label titleLabel ;
	
	@FXML
	private Button homeButton ;
	
	@FXML
	private Button insertButton ;
	
	@FXML
	private Button chartButton ;
	
	@FXML
	private DatePicker dateFilter ;
	
	@FXML 
	private ComboBox<String> typeFilter ; 
	
	@FXML
	private TableView<Transaction> displayTable ;
	
	
	
	@FXML
	private void insertData(ActionEvent e) throws IOException {
		Parent insertDataPage = FXMLLoader.load(getClass().getResource("insertData.fxml")) ;
		Scene insertDataScene = new Scene(insertDataPage) ;
		
		Stage app = (Stage) ((Node) e.getSource()).getScene().getWindow() ;
		app.setScene(insertDataScene);
		app.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
