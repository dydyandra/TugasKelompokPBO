package id.ac.its.fp;

import java.io.File;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import id.ac.its.fp.obj.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class FXMLDetailDataController implements Initializable {

	@FXML
	private Label displayDate ;
	
	@FXML
	private Label typeDisplay ;
	
	@FXML
	private Label descDisplay ;
	
	@FXML
	private Label amountDisplay ;
	
	@FXML
	private Label categoryDisplay ;
	
	@FXML
	private ImageView imageDisplay ;
	
	private Transaction transaction ;
	
	@FXML
	private void backBtnPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			loader.setController(new FXMLMainMenuController());
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
	
	public FXMLDetailDataController(Transaction transaction) {
		this.transaction = transaction ;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
		displayDate.setText(transaction.getLocalTime().format(localFormat));
		
		typeDisplay.setText(transaction.getType());
		
		if (transaction.getDescription().equals("")) {
			descDisplay.setText("No Description");
		}
		else {
			descDisplay.setText(transaction.getDescription());
		}
	
		amountDisplay.setText(transaction.getStringValue());
		
		categoryDisplay.setText(transaction.getCategory());
		
		Path path = Paths.get("src/id/ac/its", transaction.getImagePath()) ;
		
		File temp = new File(path.toAbsolutePath().toString()) ;
		
		Image image = new Image(temp.toURI().toString()) ;
		
		imageDisplay.setImage(image);
		
	}

}
