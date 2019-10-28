package a5;

public class BluePlate extends PlateImpl implements Plate{
	public BluePlate(Sushi contents) throws PlatePriceException{
		super(contents, 4.0, Plate.Color.BLUE); 
		if (contents == null) {
			this.plate = null; //creates a null plate
		} else if (contents.getCost() > 4.0) { //price can't be more than 4
			throw new PlatePriceException(); 
		}
	}

}
