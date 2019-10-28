package a4;

public class Rice extends IngredientClass implements Ingredient{

	public Rice() {
		this.name = "rice"; 
		this.pricePerOunce = 0.13; 
		this.caloriesPerOunce = 34; 
		this.vegetarian = true; 
		this.rice = true; 
		this.shellfish = false; 
	}
}
