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
	
	public static List<Transaction> readData(String category) {
		openFile() ;
		List<Transaction> temp = showTransaction(category) ;
		closeFile() ;
		
		return temp ;
	}
	
	public static void readCurrentDay() {
		openFile() ;
		currentDayTransaction() ;
		closeFile() ;
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
	
	public static List<Transaction> showTransaction(String category) {
		List<Transaction> transactionList = new ArrayList<>() ;
		try {
			while(true) {
				Transaction transaction = (Transaction) input.readObject() ;
				if (transaction.getCategory() == category || category == null)
					transactionList.add(transaction) ;
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
		finally {
			
			return transactionList ;
		}
	}
	
	public static void currentDayTransaction() {
		try {
			income = 0 ;
			outcome = 0 ;
			while(true) {
				Transaction transaction = (Transaction) input.readObject() ;
				
				LocalDateTime now = LocalDateTime.now();
				
				if (now.toLocalDate().toString().compareTo(
						transaction.getLocalTime().toLocalDate().toString()) == 0) {
					if (transaction.getType().compareTo("Income") == 0)
						income += transaction.getValue() ;
					else if (transaction.getType().compareTo("Outcome") == 0)
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
		finally {
			System.out.println("Current Day :");
			System.out.println("Income : Rp. " + income) ;
			System.out.println("Outcome : Rp. " + outcome) ;
		}
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
