package a3;

public class MenuItemImpl implements MenuItem {
	private String name; 
	private IngredientPortion[] ingredients;
	private IngredientPortion[] ingredientClone;
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		this.name = name; 
		this.ingredients = ingredients; 
		this.ingredientClone = ingredients.clone(); 
		if (name == null) {
			throw new RuntimeException("Name should not be null");
		}
		if (ingredients == null || ingredients.length <= 0) {
			throw new RuntimeException("Ingredients should not be null");
		}
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				throw new RuntimeException("Ingredient cannot be null");
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public IngredientPortion[] getIngredients() { 
		return this.ingredients.clone(); 
	}


	public int getCalories() {
		int calorieSum = 0; 
		for (int i = 0; i < ingredientClone.length; i++) {
			calorieSum += ingredientClone[i].getCalories();
		}
		return calorieSum;
	}

	public double getCost() {
		double costSum = 0; 
		for (int i = 0; i < ingredientClone.length; i++) {
			costSum += ingredientClone[i].getCost(); 
		}
		return costSum;
	}

	public boolean getIsVegetarian() {
		for (int i = 0; i < ingredientClone.length; i++) {
			if (ingredientClone[i].getIsVegetarian() == false) {
				return false;
			}
		}
		return true; 
	}

}
