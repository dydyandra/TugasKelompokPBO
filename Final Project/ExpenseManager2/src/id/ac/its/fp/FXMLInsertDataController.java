package id.ac.its.fp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import id.ac.its.fp.obj.Transaction;
import id.ac.its.fp.utility.SaveTransaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import static id.ac.its.fp.utility.Messages.*;

public class FXMLInsertDataController implements Initializable {
	
	@FXML 
	private Tab incomeTab ;
	
	@FXML
	private Tab outcomeTab ;
	
	@FXML
	private TextField amount ;
	
	@FXML
	private TextField description ;
	
	@FXML
	private Button saveBtn ;
	
	@FXML
	private Button cancelBtn ;
	
	@FXML
	private Button addFileBtn ;
	
	@FXML 
	private ChoiceBox<String> categoryChoice ;
	
	@FXML
	private TextField uploadFile ;
	
	@FXML
	private TextField amountIn ;
	
	@FXML
	private TextField descriptionIn ;
	
	@FXML
	private Button saveBtnIn ;
	
	@FXML
	private Button cancelBtnIn ;
	
	@FXML
	private Button addFileBtnIn ;
	
	@FXML 
	private ChoiceBox<String> categoryChoiceIn ;
	
	@FXML
	private TextField uploadFileIn ;
	
	@FXML
	private Button insertBtnId ;
	
	@FXML
	private void homeBtnPress(ActionEvent e) {
		backToMenu(e) ;
	}
	
	@FXML
	private void chartBtnPress(ActionEvent e) {
		goToChart(e) ;
	}
	
	@FXML
	private void addFile(ActionEvent e) throws IOException {
		FileChooser fc = new FileChooser() ;
		fc.getExtensionFilters().add(new ExtensionFilter("Picture Files", "*.jpg")) ;
		File f = fc.showOpenDialog(null) ;
		
		if (f != null) {
			uploadFile.setText(f.getAbsolutePath());
		}
	}
	
	@FXML
	private void addFileIn(ActionEvent e) throws IOException {
		FileChooser fc = new FileChooser() ;
		fc.getExtensionFilters().add(new ExtensionFilter("Picture Files", "*.jpg")) ;
		File f = fc.showOpenDialog(null) ;
		
		if (f != null) {
			uploadFileIn.setText(f.getAbsolutePath());
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		insertBtnId.setDisable(true) ;
		
		categoryChoice.getItems().add("Select") ;
		categoryChoice.getItems().add("Food") ;
		categoryChoice.getItems().add("Electronic") ;
		categoryChoice.getItems().add("Transportation") ;
		categoryChoice.getItems().add("Outfit") ;
		categoryChoice.getItems().add("Education") ;
		categoryChoice.getItems().add("Other") ;
		categoryChoice.getSelectionModel().selectFirst() ;
		
		categoryChoiceIn.getItems().add("Select") ;
		categoryChoiceIn.getItems().add("Salary") ;
		categoryChoiceIn.getItems().add("Allowance") ;
		categoryChoiceIn.getItems().add("Bonus") ;
		categoryChoiceIn.getItems().add("Other") ;
		categoryChoiceIn.getSelectionModel().selectFirst() ;
		
		saveBtn.setOnAction((ActionEvent e) -> {
			if (amount.getText().trim().equals( "" )) {
				showError("Please insert transaction amount.", "Warning") ;
			}
			else if (categoryChoice.getValue().toString().trim().equals("Select")) {
				showError("Please choose category.", "Warning") ;
			}
			else {
				double value = Double.parseDouble(amount.getText().trim()) ;
				String desc = description.getText().trim() ;
				String choice = categoryChoice.getValue().toString().trim() ;
				Transaction newTransaction = new Transaction(
						"Outcome", value, LocalDateTime.now(), choice, desc, "" 
						) ;
				
				String source = uploadFile.getText().trim() ;
				SaveTransaction.insertData(newTransaction, source);
				backToMenu(e) ;
			}
			
		});
		
		saveBtnIn.setOnAction((ActionEvent e) -> {
			if (amountIn.getText().trim().equals( "" )) {
				showError("Please insert transaction amount.", "Warning") ;
			}
			else if (categoryChoiceIn.getValue().toString().trim().equals("Select")) {
				showError("Please choose category.", "Warning") ;
			}
			else {
				double value = Double.parseDouble(amountIn.getText().trim()) ;
				String desc = descriptionIn.getText().trim() ;
				String choice = categoryChoiceIn.getValue().toString().trim() ;
				Transaction newTransaction = new Transaction(
						"Income", value, LocalDateTime.now(), choice, desc, "" 
						) ;
				
				String source = uploadFileIn.getText().trim() ;
				SaveTransaction.insertData(newTransaction, source);
				backToMenu(e) ;
			}
		});
		
		cancelBtn.setOnAction((ActionEvent event) -> {
			backToMenu(event) ;
		});
		
		cancelBtnIn.setOnAction((ActionEvent event) -> {
			backToMenu(event) ;
		});
		
	}
	
	private void goToChart(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			loader.setController(new FXMLChartController());
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
	
	private void backToMenu(ActionEvent event) {
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

}
