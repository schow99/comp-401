package a6;

public class IngredientPortionClass implements IngredientPortion {
	
	public Ingredient ing; 
	public double amount; 
	
	//constructor 
	public IngredientPortionClass() {
		
	}
	
	//gets amount of ingredient
	public IngredientPortionClass (double amount) {
		this.amount = amount; 		
	}
	
	
	//gets type of ingredient
	@Override
	public Ingredient getIngredient() {
		return this.ing; 
	}
	
	//gets name 
	@Override
	public String getName() {
		return this.ing.getName(); 
	}

	//gets amount
	@Override
	public double getAmount() {
		return this.amount; 
	}

	//gets number of calories 
	@Override
	public double getCalories() {
		return this.ing.getCaloriesPerOunce() * this.amount; 
	}

	//gets total cost 
	@Override
	public double getCost() {
		return this.ing.getPricePerOunce() * this.amount; 
	}

	//gets if it is vegetarian 
	@Override
	public boolean getIsVegetarian() {
		return this.ing.getIsVegetarian(); 
	}
	
	//gets if it has rice 
	@Override
	public boolean getIsRice() {
		return this.ing.getIsRice(); 
	}

	//gets if it has shellfish 
	@Override
	public boolean getIsShellfish() {
		return this.ing.getIsShellfish(); 
	}

	//combines the two portions 
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			IngredientPortion newPortion = new IngredientPortionClass(this.amount); 
			return newPortion;
		}
		if (!other.getName().equals(this.ing.getName())){
			throw new RuntimeException("Must use the same ingredient");
		}
		
		IngredientPortion newPortion = new IngredientPortionClass(this.amount + other.getAmount()); 
		return newPortion; 
	}
	
}
