package a4;

public class ShrimpPortion extends IngredientPortionClass implements IngredientPortion{

	public ShrimpPortion(double amount) {
		super(amount); 
		if (amount <= 0) {
			throw new RuntimeException("Need amount greater than 0");
		}
		this.ing = new Shrimp(); 
		
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			IngredientPortion newPortion = new ShrimpPortion(this.amount); 
			return newPortion;
		}
		if (!other.getName().equals(this.ing.getName())) {
			throw new RuntimeException("Must use the same ingredient");
		}
		
		IngredientPortion newPortion = new ShrimpPortion(this.amount + other.getAmount()); 
		return newPortion; 
	}
	
}
