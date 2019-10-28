package a6;

public class IngredientClass implements Ingredient {
	String name; 
	double pricePerOunce; 
	int caloriesPerOunce; 
	boolean vegetarian;
	boolean rice; 
	boolean shellfish; 
	
	IngredientClass(){ 
		
	}
	
	@Override
	public String getName() {
		return this.name; 
	}

	@Override
	public double getCaloriesPerDollar() {
		return this.caloriesPerOunce / this.pricePerOunce; 
	}

	@Override
	public int getCaloriesPerOunce() {
		return this.caloriesPerOunce; 
	}

	@Override
	public double getPricePerOunce() {
		return this.pricePerOunce; 
	}

	@Override
	public boolean equals(Ingredient other) {
		if (this.name.equals(other.getName()) && this.caloriesPerOunce == other.getCaloriesPerOunce() && this.pricePerOunce - other.getPricePerOunce() < 0.01) {
			if (this.vegetarian == other.getIsVegetarian() && this.rice == other.getIsRice() && this.shellfish == other.getIsShellfish()) {
				return true; 
			}
		}
		return false; 
	}

	@Override
	public boolean getIsVegetarian() {
		return this.vegetarian; 
	}

	@Override
	public boolean getIsRice() {
		return this.rice; 
	}

	@Override
	public boolean getIsShellfish() {
		return this.shellfish; 
	}

}
