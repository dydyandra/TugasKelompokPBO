package id.ac.its.fp;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import id.ac.its.fp.obj.*;
import id.ac.its.fp.utility.LoadTransaction;

public class FXMLMainMenuController implements Initializable {
	
	@FXML
	private AnchorPane titlecontainer ;
	
	@FXML
	private Label titleLabel ;
	
	@FXML
	private AnchorPane mainDisplay ;
	
	@FXML
	private SplitPane mainContainer ;
	
	@FXML
	private AnchorPane tableAddFilter ;
	
	@FXML
	private AnchorPane dailyDisplay ;
	
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
	
	public List<Transaction> transactionList ;
	
	@FXML 
	private TableColumn <Transaction, String> type ;
	
	@FXML
	private TableColumn <Transaction, LocalDateTime> date ;
	
	@FXML
	private TableColumn <Transaction, String> category ;
	
	@FXML
	private TableColumn <Transaction, Double> value ;
	
	@FXML
	private TableColumn <Transaction, Void> detail ;
	
	@FXML
	private Label totalIncome ;
	
	@FXML
	private Label totalOutcome ;
	
	@FXML
	private void resetBtnPressed(ActionEvent e) {
		dateFilter.setValue(null);
	}
	
	@FXML
	private void chartBtnPress(ActionEvent e) {
		goToChart(e) ;
	}
	
	@FXML
	private void insertData(ActionEvent event) throws IOException {
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

		homeButton.setDisable(true) ;
		
		typeFilter.getItems().add("All") ;
		typeFilter.getItems().add("Income") ;
		typeFilter.getItems().add("Salary") ;
		typeFilter.getItems().add("Bonus") ;
		typeFilter.getItems().add("Allowance") ;
		typeFilter.getItems().add("Outcome") ;
		typeFilter.getItems().add("Food") ;
		typeFilter.getItems().add("Electronic") ;
		typeFilter.getItems().add("Transportation") ;
		typeFilter.getItems().add("Outfit") ;
		typeFilter.getItems().add("Education") ;
		typeFilter.getItems().add("Other") ;
		typeFilter.getSelectionModel().selectFirst() ;
		
		typeFilter.setOnAction((ActionEvent e) -> {
			filterTransaction() ;
		});

		filterTransaction() ;
		
		List<Double> totalValue = LoadTransaction.readDaily() ;
		
		Double income = totalValue.get(0) ;
		Double outcome = totalValue.get(1) ;
		
		totalIncome.setText(income.toString());
		totalOutcome.setText(outcome.toString());
		
		if (income > outcome) {
			totalIncome.setStyle("-fx-text-fill:green");
			totalOutcome.setStyle("-fx-text-fill:red");
		}
		else if (income < outcome) {
			totalIncome.setStyle("-fx-text-fill:red");
			totalOutcome.setStyle("-fx-text-fill:green");			
		}
		else {
			totalIncome.setStyle("-fx-text-fill:green");
			totalOutcome.setStyle("-fx-text-fill:green");			
		}
		
		dateFilter.setOnAction((ActionEvent e) -> {
			filterTransaction() ;
		});
		
	}
	
	public void filterTransaction() {
		String temp ; 
		if (dateFilter.getValue() == null)
			temp = "" ;
		else {
			DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
			temp = dateFilter.getValue().format(localFormat) ;
		}
			
		transactionList = LoadTransaction.readData(typeFilter.getValue().toString().trim(),
				temp
				) ;
		createTable() ;
	}
	
	public void createTable() {
		type.setText("Type");
		type.setPrefWidth(60.0);
		type.setCellValueFactory(
				new PropertyValueFactory<Transaction, String>("type")
				);
		
		date.setText("Date");
		date.setPrefWidth(122.0);
		date.setCellValueFactory(
				new PropertyValueFactory<Transaction, LocalDateTime>("transactionTime") 
				);
		
		category.setText("Category");
		category.setPrefWidth(108.0);
		category.setCellValueFactory(
				new PropertyValueFactory<Transaction, String>("category") 
				);
		
		value.setText("Value");
		value.setPrefWidth(113.0);
		value.setCellValueFactory(
				new PropertyValueFactory<Transaction, Double>("value") 
				);
		displayTable.getColumns().clear();
		displayTable.getItems().clear();
		displayTable.getColumns().addAll(type, date, category, value) ;
		displayTable.getItems().addAll(transactionList) ;
		
		addButtonToTable() ;
	}
	
	private void addButtonToTable() {

        Callback<TableColumn<Transaction, Void>, TableCell<Transaction, Void>> cellFactory = new Callback<TableColumn<Transaction, Void>, TableCell<Transaction, Void>>() {
            @Override
            public TableCell<Transaction, Void> call(final TableColumn<Transaction, Void> param) {
                final TableCell<Transaction, Void> cell = new TableCell<Transaction, Void>() {

                    private final Button btn = new Button("View");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                        	//
                        	try {
                        		TableRow temp = this.getTableRow() ;
                        		int idx = temp.getIndex() ;
                        		
                    			FXMLLoader loader = new FXMLLoader() ;
                    			loader.setController(new FXMLDetailDataController(transactionList.get(idx)));
                    	        loader.setLocation(getClass().getResource("viewDetails.fxml"));
                    	        Parent root = loader.load();
                    			Scene scene = new Scene(root);
                    			Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                    			app.setScene(scene);
                    			app.show();
                    		} catch(Exception e) {
                    			e.printStackTrace();
                    		}
                            //
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        
        detail.setText("Detail");
        detail.setPrefWidth(147.0);
        detail.setCellFactory(cellFactory);
        displayTable.getColumns().add(detail) ;
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
	
}
