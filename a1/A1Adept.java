package a1;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int items = scan.nextInt(); 
		String[] itemList = new String[items];
		double[] priceList = new double[items];
		for (int i = 0; i < items; i++) {
			String itemName = scan.next(); 
			double price = scan.nextDouble(); 
			itemList[i] = itemName; 
			priceList[i] = price;
		}
		int customers = scan.nextInt(); 
		String[] firstNameList = new String[customers]; 
		String[] lastNameList = new String[customers]; 
		double[] totalCustomerSpendingList = new double[customers];
		for (int i = 0; i < customers; i++) {
			double customerSpending = 0; 
			String firstName = scan.next();
			String lastName = scan.next(); 
			int numberOfItems = scan.nextInt(); 
			for (int j = 0; j < numberOfItems; j++) {
				int quantity = scan.nextInt(); 
				String itemName = scan.next(); 
				for (int l = 0; l < itemList.length; l++) {
					if (itemList[l].equals(itemName)) {
						customerSpending += quantity * priceList[l]; 
					}
				}
			}
			firstNameList[i] = firstName; 
			lastNameList[i] = lastName; 
			totalCustomerSpendingList[i] = customerSpending; 
		}
		double totalCustomerSpendingFinal = 0; 
		for (int i = 0; i < totalCustomerSpendingList.length; i++) {
			totalCustomerSpendingFinal += totalCustomerSpendingList[i];
		}
		double biggest = totalCustomerSpendingList[0]; 
		double smallest = totalCustomerSpendingList[0]; 
		String biggestCustomerFirstName = firstNameList[0]; 
		String biggestCustomerLastName = lastNameList[0]; 
		String smallestCustomerFirstName = firstNameList[0]; 
		String smallestCustomerLastName = lastNameList[0]; 
		for (int i = 1; i < totalCustomerSpendingList.length; i++) {
			if (totalCustomerSpendingList[i] > biggest) {
				biggest = totalCustomerSpendingList[i];
				biggestCustomerFirstName = firstNameList[i]; 
				biggestCustomerLastName = lastNameList[i]; 
			}
			if (totalCustomerSpendingList[i] < smallest) {
				smallest = totalCustomerSpendingList[i];
				smallestCustomerFirstName = firstNameList[i]; 
				smallestCustomerLastName = lastNameList[i]; 
			}
		}
		
		System.out.println("Biggest: " + biggestCustomerFirstName + " " + biggestCustomerLastName + " (" + String.format("%.2f", biggest) + ")");
		System.out.println("Smallest: " + smallestCustomerFirstName + " " + smallestCustomerLastName + " (" +String.format("%.2f", smallest) + ")");
		System.out.println("Average: " + String.format("%.2f", totalCustomerSpendingFinal / customers));
	}
	
}


