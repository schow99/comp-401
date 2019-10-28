package a6;

public class BluePlate extends PlateImpl implements Plate{
	public BluePlate(Sushi contents) throws PlatePriceException{
		super(contents, 4.0, Plate.Color.BLUE); 
		if (contents == null) {
			this.plate = null; 
		} else if (contents.getCost() > 4.0) {
			throw new PlatePriceException(); 
		}
	}

}
