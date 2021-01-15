package id.ac.its.fp ;

import java.util.Scanner;

import id.ac.its.fp.utility.InsertTransaction;
import id.ac.its.fp.utility.ReadTransaction;

public class Main {
	
	private static Scanner input ;
	
	public static void showMenu() {
		System.out.println();
		System.out.println("Transaction Timeline :");
		ReadTransaction.readAllData() ;
		
		System.out.println();
		System.out.println("Choose :");
		System.out.println("1. New Transaction");
		System.out.println("2. Transaction Calendar");
		System.out.println("3. Current Day Transaction Total");
		System.out.println("4. Filter by Category");
		System.out.printf(">> ");
		
		askChoice() ;
	}
	
	public static void main(String[] args) {
		input = new Scanner(System.in) ;
		showMenu() ;
	}
	
	public static void askChoice() {
		
		int choice = input.nextInt() ;
		if (choice == 1) {
			InsertTransaction.insertData() ;
		}
		else if (choice == 2) {
			// Coming soon
		}
		else if (choice == 3) {
			ReadTransaction.readCurrentDay();
		}
		
		showMenu() ;
	}
	
}
