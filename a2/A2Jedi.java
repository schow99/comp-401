package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfIngredients = scan.nextInt(); 
		String[] ingredientName = new String[numberOfIngredients];
		double[] pricePerOunce = new double[numberOfIngredients];
		int[] caloriesPerOunce = new int[numberOfIngredients]; 
		for (int i = 0; i < numberOfIngredients; i++) {
			ingredientName[i] = scan.next(); 
			pricePerOunce[i] = scan.nextDouble(); 
			boolean vegetarian = scan.nextBoolean(); 
			caloriesPerOunce[i] = scan.nextInt(); 
		}
		int numberOfMenuItems = scan.nextInt(); 
		String[] menuItemName = new String[numberOfMenuItems];
		double[][] totalOunces = new double [numberOfMenuItems][numberOfIngredients];
		double[] returnOunces = new double[numberOfIngredients];
		for (int i = 0; i < numberOfMenuItems; i++) {
			menuItemName[i] = scan.next();
			int ingredients = scan.nextInt(); 
			for (int j = 0; j < ingredients; j++) {
				String name = scan.next(); 
				double ounces = scan.nextDouble();
				for (int k = 0; k < numberOfIngredients; k++) {
					if (name.equals(ingredientName[k])) {
						totalOunces[i][k] += ounces;
					}
				}
			}

		}
		String order = scan.next(); 
		while (!order.equals("EndOrder")){
			for (int i = 0; i < numberOfIngredients; i++) {
				for (int j = 0; j < numberOfMenuItems; j++) {
					if (order.equals(menuItemName[j])) {
						returnOunces[i] += totalOunces[j][i];
					}

				}
			}
			order = scan.next(); 
		} 
		System.out.println("The order will require:");
		for (int i = 0; i < returnOunces.length; i++) {				
			System.out.println(String.format("%.2f", returnOunces[i]) + " ounces of " + ingredientName[i]);
		}
	}

}
