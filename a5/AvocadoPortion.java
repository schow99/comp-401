package a5;

public class AvocadoPortion extends IngredientPortionClass implements IngredientPortion{

	public AvocadoPortion(double amount) {
		super(amount); //super constructor passing amount
		if (amount <=0) {
			throw new RuntimeException("Ingredient must be greater than 0"); 
		}
		this.ing = new Avocado(); //creates new avocado
	}


	public IngredientPortion combine(IngredientPortion other) {
			if (other == null) { //if the other parameter is null
				IngredientPortion newPortion = new AvocadoPortion(this.amount); 
				return newPortion; //return current object
			}
			if (!other.getName().equals(this.ing.getName())) { //if other name isn't the same as this ingredient name
				throw new RuntimeException("Must use the same ingredient");
			}
			
			IngredientPortion newPortion = new AvocadoPortion(this.amount + other.getAmount()); //new portion adding the amounts 
			return newPortion; 
		}
		
	


}
