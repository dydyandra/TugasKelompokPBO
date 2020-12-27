package id.ac.its.fp.obj;
import javafx.scene.image.Image;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class Transaction {
	private int id ;
	private String type ;
	private double value ;
	private LocalDateTime transactionTime ;
	private String category ;
	private String description ;
	private Path path ;
	
	public Transaction(int id, String type, double value, LocalDateTime transactionTime, String category,
			String description, Path path) {
		
		this.id = id;
		this.type = type;
		this.value = value;
		this.transactionTime = transactionTime;
		this.category = category;
		this.description = description;
		this.path = path;
	}
	
	public Path getImagePath() {
		return path ;
	}
	
	public void setImagePath(Path path) {
		this.path = path ;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
