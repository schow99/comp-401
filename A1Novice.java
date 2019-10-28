package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberCustomers = scan.nextInt(); 
		for (int i = 0; i < numberCustomers; i++) {
			String name = scan.next();
			String lastName = scan.next(); 
			int differentItems = scan.nextInt(); 
			double totalPrice = 0; 
			for (int j = 0; j < differentItems; j++) {
				int quantity = scan.nextInt(); 
				String thing = scan.next(); 
				double price = scan.nextDouble(); 
				totalPrice = totalPrice + quantity * price; 
			}
			
			System.out.println(name.charAt(0) + ". " + lastName + ": " + String.format("%.2f", totalPrice));
		}
	}
	
}
