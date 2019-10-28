package a6;

public class Shrimp extends IngredientClass implements Ingredient {
	
	public Shrimp () {
		this.name = "shrimp"; 
		this.pricePerOunce = 0.65; 
		this.caloriesPerOunce = 32; 
		this.vegetarian = false; 
		this.rice = false; 
		this.shellfish = true; 
	}

}
