package a6;

import a6.Sashimi.SashimiType;

public class Nigiri implements Sushi {

	private IngredientPortion portion; 
	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	private NigiriType type;
	private IngredientPortion rice; 
	
	public Nigiri(NigiriType type) {
		this.type = type; 
		rice = new RicePortion(0.5); 
		switch(type) {
		case TUNA: 
			portion = new TunaPortion(0.75); 
			break;
		case YELLOWTAIL: 
			portion = new YellowtailPortion(0.75); 
			break; 
		case EEL: 
			portion = new EelPortion(0.75); 
			break; 
		case CRAB: 
			portion = new CrabPortion(0.75); 
			break; 
		case SHRIMP: 
			portion = new ShrimpPortion(0.75); 
			break; 
		}
	}
	@Override
	public String getName() {
		return portion.getName() + " nigiri"; 
	}
	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] value = new IngredientPortion[2]; 
		value[0] = portion;
		value[1] = rice; 
		return value;  
	}
	@Override
	public int getCalories() {
		return (int) Math.round(portion.getCalories() + rice.getCalories()); 
	}
	@Override
	public double getCost() {
		//return (double)(((portion.getCost() + rice.getCost()) * 100.0) / 100.0);
		return ((int)((portion.getCost() * 100.0) + 0.5)) /100.0; 
	}
	@Override
	public boolean getHasRice() {
		return rice.getIsRice(); 
	}
	@Override
	public boolean getHasShellfish() {
		return portion.getIsShellfish(); 
	}
	@Override
	public boolean getIsVegetarian() {
		return portion.getIsVegetarian(); 
	}



}
