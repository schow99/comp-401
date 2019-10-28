package a6;

public class GoldPlate extends PlateImpl implements Plate{

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(contents, price, Plate.Color.GOLD);
		if (contents == null) {
			this.plate = null; 
		} 
		else if (this.price < contents.getCost()) {
			throw new PlatePriceException();
		}
		if (price < 5.0) {
			throw new IllegalArgumentException("Price cannot be less than 5"); 
		}

	}


}
