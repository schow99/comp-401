package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfIngredients = scan.nextInt(); 
		String[] ingredientName = new String[numberOfIngredients];
		double[] pricePerOunce = new double[numberOfIngredients];
		int[] caloriesPerOunce = new int[numberOfIngredients]; 
		boolean[] isVegetarian = new boolean[numberOfIngredients]; 
		for (int i = 0; i < numberOfIngredients; i++) {
			ingredientName[i] = scan.next(); 
			pricePerOunce[i] = scan.nextDouble(); 
			isVegetarian[i] = scan.nextBoolean(); 
			caloriesPerOunce[i] = scan.nextInt(); 
		}
		
		int numberOfMenuItems = scan.nextInt(); 
		String[] menuItemName = new String[numberOfMenuItems];
		for (int i = 0; i < numberOfMenuItems; i++) {
			double calorieCount = 0; 
			double cost = 0; 
			boolean vegetarian = true; 
			menuItemName[i] = scan.next(); 
			int ingredients = scan.nextInt(); 
			for (int j = 0; j < ingredients; j++) {
				String name = scan.next(); 
				double ounces = scan.nextDouble(); 
				for (int k = 0; k < ingredientName.length; k++) {
					if (name.equals(ingredientName[k])) {
						calorieCount += ounces * caloriesPerOunce[k]; 
						cost += ounces * pricePerOunce[k];
						if (!isVegetarian[k]) {
							vegetarian = false; 
						}
					}
				}
			}
			System.out.println(menuItemName[i] + ":");
			System.out.println( ((int) (calorieCount + 0.5)) + " calories");
			System.out.println("$" + String.format("%.2f", cost));
			if (vegetarian) {
				System.out.println("Vegetarian");
			} 
			else {
				System.out.println("Non-Vegetarian");
			}
		}
		
	}
	
	
}
