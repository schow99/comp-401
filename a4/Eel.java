package a4;

public class Eel extends IngredientClass implements Ingredient {
	
	public Eel(){ 
		this.name = "eel"; 
		this.pricePerOunce = 2.15; 
		this.caloriesPerOunce = 82; 
		this.vegetarian = false; 
		this.rice = false; 
		this.shellfish = false; 
	}

}
