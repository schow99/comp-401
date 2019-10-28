package a6;

public class AvocadoPortion extends IngredientPortionClass implements IngredientPortion{

	public AvocadoPortion(double amount) {
		super(amount); 
		if (amount <=0) {
			throw new RuntimeException("Ingredient must be greater than 0"); 
		}
		this.ing = new Avocado(); 
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
