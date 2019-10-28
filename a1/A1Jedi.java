package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int items = scan.nextInt(); 
		String[] itemList = new String[items];
		int[] customersBought = new int[items]; 
		int[] itemsBought = new int[items];
		boolean[] repeated = new boolean[items];
		for (int i = 0; i < items; i++) {
			String itemName = scan.next(); 
			double price = scan.nextDouble(); 
			itemList[i] = itemName; 
			repeated[i] = false;
		}
		int totalItems = 0; 
		int customers = scan.nextInt();
		for (int i = 0; i < customers; i++) {
			String firstName = scan.next();
			String lastName = scan.next(); 
			int numberOfItems = scan.nextInt();
			totalItems = numberOfItems;
			for (int j = 0; j < numberOfItems; j++) {
				int quantity = scan.nextInt(); 
				String itemName = scan.next(); 
				for (int l = 0; l < itemList.length; l++) {
					if (itemList[l].equals(itemName)) {
						if (repeated[l] == false) {
							itemsBought[l] += quantity; 
							customersBought[l]++;
							repeated[l] = true; 
						}
						else {
							itemsBought[l] += quantity;
						}
					}
				}
			}
			for (int k = 0; k < repeated.length; k++) {
				repeated[k] = false;
			}
		}

		for (int i = 0; i < itemList.length; i++) {
			if (itemsBought[i] == 0) {
				System.out.println("No customers bought " + itemList[i]);
			}
			else {
				System.out.println(customersBought[i] + " customers bought " + itemsBought[i] + " " + itemList[i]);
			}
		}
		
	}

	
}
