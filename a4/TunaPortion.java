package a4;

public class TunaPortion extends IngredientPortionClass implements IngredientPortion{
	
	public TunaPortion(double amount) {
		super(amount); 
		if (amount <= 0) {
			throw new RuntimeException("Need amount greater than 0");
		}
		this.ing = new Tuna(); 
		
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			IngredientPortion newPortion = new TunaPortion(this.amount); 
			return newPortion;
		}
		if (!other.getName().equals(this.ing.getName())) {
			throw new RuntimeException("Must use the same ingredient");
		}
		
		IngredientPortion newPortion = new TunaPortion(this.amount + other.getAmount()); 
		return newPortion; 
	}

}
