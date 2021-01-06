package id.ac.its.fp.utility;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import id.ac.its.fp.obj.Transaction;

public class LoadTransaction {
	
	private static ObjectInputStream input;
	private static double income ;
	private static double outcome ;
	
	public static List<Transaction> readData(String category, String date) {
		openFile() ;
		List<Transaction> temp = showTransaction(category, date) ;
		closeFile() ;
		
		return temp ;
	}
	
	public static List<Double> readDaily() {
		openFile() ;
		List<Double> temp = currentDayTransaction() ;
		closeFile() ;
		return temp ;
	}
	
	public static void openFile() {
		try {
			Path path = Paths.get("src/id/ac/its/fp", "data.ser") ;
			input = new ObjectInputStream(
					Files.newInputStream(path));
		}
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	public static List<Transaction> showTransaction(String category, String date) {
		List<Transaction> transactionList = new ArrayList<>() ;
		try {
			while(true) {
				Transaction transaction = (Transaction) input.readObject() ;
				if (transaction.getCategory().equals(category) || category.equals("Filter") || transaction.getType().equals(category)) {
					if (transaction.getTransactionTime().equals(date) || date.equals(""))
						transactionList.add(0, transaction) ;
				}
			}
		}
		catch (EOFException endOfFileException) {
			
		}
		catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
			System.err.println("Error reading from file. Terminating.");
		}
		
		return transactionList ;
	}
	
	public static List<Double> currentDayTransaction() {
		List<Double> value = new ArrayList<>() ;
		try {
			income = 0 ;
			outcome = 0 ;
			while(true) {
				Transaction transaction = (Transaction) input.readObject() ;
				
				LocalDateTime now = LocalDateTime.now();
				
				if (now.toLocalDate().toString().compareTo(
						transaction.getLocalTime().toLocalDate().toString()) == 0) {
					if (transaction.getType().equals("Income"))
						income += transaction.getValue() ;
					else if (transaction.getType().equals("Outcome"))
						outcome += transaction.getValue() ;					
				}
				
				
			}
			
		}
		catch (EOFException endOfFileException) {
			
		}
		catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
			System.err.println("Error reading from file. Terminating.");
		}
		value.add(income) ;
		value.add(outcome) ;
		return value ;
	}
	
	public static void closeFile() {
		try {
			if (input != null)
				input.close();
		}
		catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
	
	
}
