package a5;

public class EelPortion extends IngredientPortionClass implements IngredientPortion{

	public EelPortion(double amount) {
		super(amount); 
		if (amount <= 0) {
			throw new RuntimeException("Need amount greater than 0");
		}
		this.ing = new Eel(); 
		
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			IngredientPortion newPortion = new EelPortion(this.amount); 
			return newPortion;
		}
		if (!other.getName().equals(this.ing.getName())) {
			throw new RuntimeException("Must use the same ingredient");
		}
		
		IngredientPortion newPortion = new EelPortion(this.amount + other.getAmount()); 
		return newPortion; 
	}
}
