package a3;

import java.util.Scanner;

public class A3Jedi {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in); 
		int numberOfIngredients = scan.nextInt();
		IngredientImpl[] ingredientArray = new IngredientImpl[numberOfIngredients];  //creates array with ingredients and properties
		String itemName; 
		double ounces; 
		int calories; 
		boolean isVegetarian; 
		for (int i = 0; i < numberOfIngredients; i++) {
			itemName = scan.next();
			ounces = scan.nextDouble(); 
			isVegetarian = scan.nextBoolean(); 
			calories = scan.nextInt(); 
			
			ingredientArray[i] = new IngredientImpl(itemName, ounces, calories, isVegetarian); //adds to array
		}
		
		int numberOfMenuItems = scan.nextInt(); 
		String[] menuItems = new String[numberOfMenuItems]; //creates array with all menu item names
		MenuItem[] menu = new MenuItem[numberOfMenuItems];
		for (int i = 0; i < numberOfMenuItems; i++) {
			menuItems[i] = scan.next(); //adds name to array
			int ingredientsInItem = scan.nextInt(); 
			IngredientPortion[] ingredientPortion = new IngredientPortion[ingredientsInItem];
			for (int j = 0; j < ingredientsInItem; j++) {
				String nameOfIngredient = scan.next(); 
				double amountOfIngredient = scan.nextDouble(); 
				for (int k = 0; k < numberOfIngredients; k++) {
					if (nameOfIngredient.equals(ingredientArray[k].getName())) { //searches for ingredient in menu item to align with array with ingredients
						ingredientPortion[j] = new IngredientPortionImpl(ingredientArray[k], amountOfIngredient); 
					}
				}
			}
			menu[i] = new MenuItemImpl(menuItems[i], ingredientPortion); 
		}
		
		IngredientPortion[] returnIngredients = new IngredientPortion[numberOfIngredients];
		String order = scan.next();
		while (!order.equals("EndOrder")) {
			for (int i = 0; i < menuItems.length; i++) {
				if (order.equals(menuItems[i])) {//checks name of menu item
					for (int j = 0; j < menu[i].getIngredients().length; j++) { //gets number of ingredients in a menu item
						for (int k = 0; k < numberOfIngredients; k++) {
							if (menu[i].getIngredients()[j].getName().equals(ingredientArray[k].getName())) { //checks if ingredient in menu is the same as ingredient name
								returnIngredients[k] = menu[i].getIngredients()[j].combine(returnIngredients[k]); //adds amount to each other 
							}
						}
						
					}
				}
			}
			order = scan.next();
		}
		System.out.println("The order will require: ");
		for (int i = 0; i < numberOfIngredients; i++) { //prints amount
			if (returnIngredients[i] == null) {
				System.out.println(String.format("%.2f", 0.0) + " ounces of " + ingredientArray[i].getName());
			}
			else {
				System.out.println(String.format("%.2f", returnIngredients[i].getAmount()) + " ounces of " + ingredientArray[i].getName());

			}
		}

	}
}
