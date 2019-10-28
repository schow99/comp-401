package a4;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Roll implements Sushi {

	private String name;
	private IngredientPortion[] roll_ingredients;
	private ArrayList<IngredientPortion> rollIngredients;

	public Roll(String name, IngredientPortion[] roll_ingredients) {
		this.name = name;
		this.roll_ingredients = roll_ingredients.clone();
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		rollIngredients = new ArrayList<IngredientPortion>();
		for (int i = 0; i < roll_ingredients.length; i++) {
			rollIngredients.add(roll_ingredients[i]);
		}

		// address duplicates
		for (int i = 0; i < rollIngredients.size(); i++) {
			for (int j = i + 1; j < rollIngredients.size(); j++) {
				if (rollIngredients.get(i).getName().equals(rollIngredients.get(j).getName())) {
					// insert new combined IngredientPortion into index i
					rollIngredients.add(i, rollIngredients.get(i).combine(rollIngredients.get(j)));
					// delete old i
					rollIngredients.remove(i+1);
					// delete old j
					rollIngredients.remove(j);
					j--;
				}
			}
		}

		boolean isSeaweed = false; 
		for (int i = 0; i < rollIngredients.size(); i++) {
			if (rollIngredients.get(i).getName().equals("seaweed")) {
				if (rollIngredients.get(i).getAmount() < 0.1) {
					rollIngredients.remove(i); 
					SeaweedPortion seaweed = new SeaweedPortion(0.1);
					rollIngredients.add(seaweed);
				}
				isSeaweed = true; 
			} 
		}
		if (!isSeaweed) {
			SeaweedPortion seaweed = new SeaweedPortion(0.1);
			rollIngredients.add(0, seaweed);
		}
		this.roll_ingredients = rollIngredients.toArray(new IngredientPortionClass[rollIngredients.size()]);
		
		/*
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] == null) {
				continue;
			}
		}

		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] == null) {
				continue;
			}
			for (int j = i + 1; j < roll_ingredients.length; j++) {
				if (roll_ingredients[i].getName().equals(roll_ingredients[j].getName())) {
					roll_ingredients[i].combine(roll_ingredients[j]);
					roll_ingredients[j] = null;
				}
			}
		}
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getName().equals("seaweed")) {
				if (roll_ingredients[i].getAmount() < 0.1) {
					SeaweedPortion seaweed = new SeaweedPortion(0.1);
					IngredientPortion[] seaweedArray = new IngredientPortion[roll_ingredients.length + 1];
					for (int j = 0; j < roll_ingredients.length; j++) {
						seaweedArray[j] = roll_ingredients[j];
					}
					seaweedArray[roll_ingredients.length] = seaweed;
					this.roll_ingredients = seaweedArray;
				}
			} else {
				SeaweedPortion seaweed = new SeaweedPortion(0.1);
				IngredientPortion[] seaweedArray = new IngredientPortion[roll_ingredients.length + 1];
				for (int j = 0; j < roll_ingredients.length; j++) {
					seaweedArray[j] = roll_ingredients[j];
				}
				seaweedArray[roll_ingredients.length] = seaweed;
				this.roll_ingredients = seaweedArray;
			}
		}
		*/

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return this.roll_ingredients;
	}

	@Override
	public int getCalories() {
		double calories = 0;
		for (int i = 0; i < this.roll_ingredients.length; i++) {
			calories += this.roll_ingredients[i].getCalories();
		}
		return (int) Math.round(calories);
	}

	@Override
	public double getCost() {
		double cost = 0;
		for (int i = 0; i < this.roll_ingredients.length; i++) {
			cost += this.roll_ingredients[i].getCost();
		}
		return (double) Math.round(cost * 100) / 100;
	}

	@Override
	public boolean getHasRice() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (this.roll_ingredients[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		for (int i = 0; i < this.roll_ingredients.length; i++) {
			if (this.roll_ingredients[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		for (int i = 0; i < this.roll_ingredients.length; i++) {
			if (this.roll_ingredients[i].getIsVegetarian() == false) {
				return false;
			}
		}
		return true;
	}

}
