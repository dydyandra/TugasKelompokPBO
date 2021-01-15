package id.ac.its.fp.obj;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class Transaction implements Serializable {
	private static int counter = 0 ;
	private int id ;
	private String type ;
	private double value ;
	private LocalDateTime transactionTime ;
	private String category ;
	private String description ;
	private String path ;
	
	public Transaction(String type, double value, LocalDateTime transactionTime, String category,
			String description, String path) {
		
		this.id = counter;
		this.type = type;
		this.value = value;
		this.transactionTime = transactionTime;
		this.category = category;
		this.description = description;
		this.path = path;
		counter++ ;
	}
	
	public String getImagePath() {
		return path ;
	}
	
	public void setImagePath(String path) {
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
		return value ;
	}
	
	public String getStringValue() {
		return String.format("Rp. %.2f", value);
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getTransactionTime() {
		
		DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
		return (String)transactionTime.format(localFormat);
	}
	
	public LocalDateTime getLocalTime() {
		return transactionTime ;
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
