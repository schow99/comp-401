package a6;

public class CrabPortion extends IngredientPortionClass implements IngredientPortion {

	public CrabPortion(double amount) {
		super(amount); 
		if (amount <= 0) {
			throw new RuntimeException("Need amount greater than 0");
		}
		this.ing = new Crab(); 
		
		
	}
	
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			IngredientPortion newPortion = new AvocadoPortion(this.amount); 
			return newPortion;
		}
		if (!other.getName().equals(this.ing.getName())) {
			throw new RuntimeException("Must use the same ingredient");
		}
		
		IngredientPortion newPortion = new AvocadoPortion(this.amount + other.getAmount()); 
		return newPortion; 
	}
	

}
