package a4;

public class RicePortion extends IngredientPortionClass implements IngredientPortion {
	
	public RicePortion(double amount) {
		super(amount); 
		if (amount <= 0) {
			throw new RuntimeException("Need amount greater than 0");
		}
		this.ing = new Rice(); 
		
		
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			IngredientPortion newPortion = new RicePortion(this.amount); 
			return newPortion;
		}
		if (!other.getName().equals(this.ing.getName())) {
			throw new RuntimeException("Must use the same ingredient");
		}
		
		IngredientPortion newPortion = new RicePortion(this.amount + other.getAmount()); 
		return newPortion; 
	}

}
