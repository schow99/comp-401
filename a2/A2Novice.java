package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfIngredients = scan.nextInt(); 
		int vegetarianCounter = 0; 
		String[] ingredientName = new String[numberOfIngredients];
		double[] pricePerOunce = new double[numberOfIngredients];
		int[] caloriesPerOunce = new int[numberOfIngredients]; 
		for (int i = 0; i < numberOfIngredients; i++) {
			ingredientName[i] = scan.next(); 
			pricePerOunce[i] = scan.nextDouble(); 
			boolean isVegetarian = scan.nextBoolean();
			if (isVegetarian) {
				vegetarianCounter++; 
			}
			caloriesPerOunce[i] = scan.nextInt(); 
			
		}
		System.out.println("Number of vegetarian ingredients: " + vegetarianCounter);
		System.out.println("Highest cals/$: " + highestCalorie(ingredientName, pricePerOunce, caloriesPerOunce));
		System.out.println("Lowest cals/$: " + lowestCalorie(ingredientName, pricePerOunce, caloriesPerOunce));
	}
	
	public static String highestCalorie(String[] ingredientName, double[] pricePerOunce, int[] caloriesPerOunce) {
		double highest = 0; 
		String highestIngredient = ""; 
		for (int i = 0; i < ingredientName.length; i++) {
			if (caloriesPerOunce[i] / pricePerOunce[i] > highest) {
				highest = caloriesPerOunce[i] / pricePerOunce[i]; 
				highestIngredient = ingredientName[i]; 
			}
		}
		return highestIngredient; 
	}
	
	public static String lowestCalorie(String[] ingredientName, double[] pricePerOunce, int[] caloriesPerOunce) {
		double lowest = caloriesPerOunce[0] / pricePerOunce[0]; 
		String lowestIngredient = ingredientName[0]; 
		for (int i = 1; i < ingredientName.length; i++) {
			if (caloriesPerOunce[i] / pricePerOunce[i] < lowest) {
				lowest = caloriesPerOunce[i] / pricePerOunce[i]; 
				lowestIngredient = ingredientName[i]; 
			}
		}
		return lowestIngredient; 
	}
	
}
