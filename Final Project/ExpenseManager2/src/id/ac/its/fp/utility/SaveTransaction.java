package id.ac.its.fp.utility;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

import id.ac.its.fp.obj.Transaction;

public class SaveTransaction {
	
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private static String oldPath ;
	private static String newPath ;
	private static boolean deleteStatus ;
	private static Transaction targetDeleteTransaction ;
	
	public static void deleteData(Transaction targetTransaction) {
		deleteStatus = true ;
		targetDeleteTransaction = targetTransaction ;
		
		openFile() ;
		rewriteFile() ;
		closeFile() ;
		
		File deleteFile = new File(newPath) ;
		deleteFile.delete();
		File newFile = new File(newPath) ;
		File oldFile = new File(oldPath) ;
		oldFile.renameTo(newFile) ;
		
		deleteStatus = false ;
	}
	
	public static void insertData(Transaction newTransaction, String src) {
		openFile() ;
		rewriteFile() ;
		insert(newTransaction, src) ;
		closeFile() ;
		
		// Hapus File Lama
		File deleteFile = new File(newPath) ;
		deleteFile.delete();
		File newFile = new File(newPath) ;
		File oldFile = new File(oldPath) ;
		oldFile.renameTo(newFile) ;
	}
	
	public static void openFile() {
		try {
			Path path = Paths.get("src/id/ac/its", "fp/dataTemp.ser") ;
			
			oldPath = path.toAbsolutePath().toString() ;
			
			output = new ObjectOutputStream(
					Files.newOutputStream(path));
		}
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void rewriteFile() {
		try {
			Path path = Paths.get("src/id/ac/its/fp", "data.ser") ;
			
			newPath = path.toAbsolutePath().toString() ;
			
			input = new ObjectInputStream(
					Files.newInputStream(path));
		}
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
		
		try {
			while(true) {
				Transaction transaction = (Transaction) input.readObject() ;
				
				if (deleteStatus && transaction.getImagePath().equals(targetDeleteTransaction.getImagePath())) {
					System.out.println("Check");
					continue ;
				}
				
				Transaction oldTransaction = new Transaction(transaction.getType(), transaction.getValue(),
						transaction.getLocalTime(), transaction.getCategory(), transaction.getDescription(), transaction.getImagePath());
				
				output.writeObject(oldTransaction);
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
		
		try {
			if (input != null)
				input.close();
		}
		catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		}
	}
	
	public static void insert(Transaction newTransaction, String src) {
		
		
		try {
			String randomString = RandomString.getAlphaNumericString(10) ;
			String path = "resources/" + randomString + ".jpg" ;
			
//			String type = input.next() ;
//			double value = input.nextDouble() ;
//			String category = input.next() ;
//			String description = input.next() ;
//			Transaction transaction = new Transaction(type, value,
//					LocalDateTime.now(), category, description, path);
			
			newTransaction.setImagePath(path);
			
			output.writeObject(newTransaction);
			
			if (!src.equals("")) {
				File source = new File(src) ;
				
				Path imagePath = Paths.get("src/id/ac/its/resources", randomString + ".jpg") ;
				
				File dest = new File(imagePath.toAbsolutePath().toString()) ;
				CopyFile.copyFile(source, dest) ;	
				
			}
			
			
		}
		catch (NoSuchElementException elementException) {
			System.err.println("Invalid input. Please try again.");
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
			System.err.println("Error writing to file. Terminating.");
		}
	
	}
	
	public static void closeFile() {
		try {
			if (output != null)
				output.close();
		}
		catch (IOException ioException) {
			
			System.err.println("Error closing file. Terminating.");
		}
	}
	
}
