package id.ac.its.fp;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import id.ac.its.fp.obj.Transaction;
import id.ac.its.fp.utility.LoadTransaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLChartController implements Initializable {

	@FXML
	private Button chartBtn ;
	
	@FXML
	private PieChart incomeChart ;
	
	@FXML
	private PieChart outcomeChart ;
	
	@FXML
	private PieChart totalChart ;
	
	@FXML
	private void homeBtnPressed(ActionEvent event) {
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
	
	@FXML
	private void insertBtnPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader() ;
			loader.setController(new FXMLInsertDataController());
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		chartBtn.setDisable(true);
		
		List<Transaction> inC = LoadTransaction.readData("Income", "") ;
		List<Transaction> outC = LoadTransaction.readData("Outcome", "") ;
		
		List <String> choiceIn = new ArrayList<>() ;
		choiceIn.add("Salary") ;
		choiceIn.add("Bonus") ;
		choiceIn.add("Allowance") ;
		choiceIn.add("Other") ;
		
		List <String> choiceOut = new ArrayList<>() ;
		choiceOut.add("Food") ;
		choiceOut.add("Electronic") ;
		choiceOut.add("Transportation") ;
		choiceOut.add("Outfit") ;
		choiceOut.add("Education") ;
		choiceOut.add("Other") ;
		
		List <Double> incomeValue = count(inC, choiceIn) ;
		List <Double> outcomeValue = count(outC, choiceOut) ;
		
		double incomeTotal = 0 ;
		double outcomeTotal = 0 ;
		
		for (int i = 0 ; i < incomeValue.size() ; i++) {
			incomeChart.getData().add(new PieChart.Data(choiceIn.get(i), incomeValue.get(i))) ;
			incomeTotal += incomeValue.get(i) ;
		}
		
		for (int i = 0 ; i < outcomeValue.size() ; i++) {
			outcomeChart.getData().add(new PieChart.Data(choiceOut.get(i), outcomeValue.get(i))) ;
			outcomeTotal += outcomeValue.get(i) ;
		}
		
		totalChart.getData().add(new PieChart.Data("Income", incomeTotal)) ;
		totalChart.getData().add(new PieChart.Data("Outcome", outcomeTotal)) ;
	}

	public List<Double> count(List <Transaction> tr, List <String> choice) {
		List <Double> value = new ArrayList<>(choice.size()) ;
		for (int i = 0 ; i < choice.size(); i++) {
			value.add(0.0) ;
			for (Transaction t : tr) {
				if (t.getCategory().equals(choice.get(i))) {
					value.set(i, t.getValue() + value.get(i)) ;
				}
			}
		}
		return value ;
	}
	
}
