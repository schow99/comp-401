package a4;

public class IngredientPortionClass implements IngredientPortion {
	
	public Ingredient ing; 
	public double amount; 
	
	public IngredientPortionClass() {
		
	}
		
	public IngredientPortionClass (double amount) {
		this.amount = amount; 		
	}

	@Override
	public Ingredient getIngredient() {
		return this.ing; 
	}

	@Override
	public String getName() {
		return this.ing.getName(); 
	}

	@Override
	public double getAmount() {
		return this.amount; 
	}

	@Override
	public double getCalories() {
		return this.ing.getCaloriesPerOunce() * this.amount; 
	}

	@Override
	public double getCost() {
		return this.ing.getPricePerOunce() * this.amount; 
	}

	@Override
	public boolean getIsVegetarian() {
		return this.ing.getIsVegetarian(); 
	}

	@Override
	public boolean getIsRice() {
		return this.ing.getIsRice(); 
	}

	@Override
	public boolean getIsShellfish() {
		return this.ing.getIsShellfish(); 
	}

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
