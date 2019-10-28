package a6;

public class Sashimi implements Sushi{

	private IngredientPortion portion; 
	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};

	private SashimiType type; 
	public Sashimi(SashimiType type) {
		this.type = type; 
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
		return portion.getName() + " sashimi"; 
	}

	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] value = new IngredientPortion[1]; 
		value[0] = portion;
		return value;  
	}

	@Override
	public int getCalories() {
		return (int) Math.round(portion.getCalories()); 
	}

	@Override
	public double getCost() {
		//return (double) Math.round(portion.getCost() * 100) / 100;
		return ((int)((portion.getCost() * 100.0) + 0.5)) /100.0; 

	}

	@Override
	public boolean getHasRice() {
		return portion.getIsRice(); 
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
