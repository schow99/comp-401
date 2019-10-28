package a5;

public class RedPlate extends PlateImpl implements Plate{
	
	public RedPlate(Sushi contents) throws PlatePriceException {
		super(contents, 1.0, Plate.Color.RED); 
		if (contents == null) {
			this.plate = null; 
		} else if (contents.getCost() > 1.0) {
			throw new PlatePriceException(); 
		}
	}

}
