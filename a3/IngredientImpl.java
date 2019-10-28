package a3;

public class IngredientImpl implements Ingredient {
	
	private String name;
	private double price; 
	private int calories; 
	private boolean is_vegetarian; 

	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		this.name = name; 
		this.price = price; 
		this.calories = calories; 
		this.is_vegetarian = is_vegetarian; 
		if (price < 0 || calories < 0) {
			throw new RuntimeException("Value cannot be negative");
		}
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getIsVegetarian() {
		return this.is_vegetarian; 
	}
	
	public double getPricePerOunce() {
		return this.price; 
	}
	
	public int getCaloriesPerOunce() {
		return this.calories; 
	}
	
	public double getCaloriesPerDollar() {
		return this.calories / this.price; 
	}
	

}
