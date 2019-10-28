package a3;

public class IngredientPortionImpl implements IngredientPortion{
	
	private Ingredient ing; 
	private double amount; 
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		this.ing = ing; 
		this.amount = amount;
		if (ing == null) {
			throw new RuntimeException("Ingredient cannot be null");
		}
	}

	public Ingredient getIngredient() { 
		return this.ing; 
	}
	
	public double getAmount() { 
		return this.amount; 
	}
	
	public String getName() { 
		return this.ing.getName();
	}
	
	public boolean getIsVegetarian() { 
		return this.ing.getIsVegetarian();
	}
	
	public double getCalories() {
		return this.ing.getCaloriesPerOunce() * this.amount; 
	}
	
	public double getCost() { 
		return this.ing.getPricePerOunce() * this.amount; 
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			IngredientPortion newPortion = new IngredientPortionImpl(this.getIngredient(), this.amount); 
			return newPortion;
		}
		if (!other.getName().equals(this.ing.getName())) {
			throw new RuntimeException("Must use the same ingredient");
		}
		
		IngredientPortion newPortion = new IngredientPortionImpl(other.getIngredient(), this.amount + other.getAmount()); 
		return newPortion; 
	}
	
	
	public static void main(String[] args) {
		IngredientPortionImpl ing1 = new IngredientPortionImpl(new IngredientImpl("jonjon", 2.2, 4, true), 20.0);
		
		System.out.println(ing1.combine(ing1).getAmount());
		
	}
	
	

}
