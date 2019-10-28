package a6;

public class GreenPlate extends PlateImpl implements Plate{
	public GreenPlate(Sushi contents) throws PlatePriceException{
		super(contents, 2.0, Plate.Color.GREEN); 
		if (contents == null) {
			this.plate = null; 
		} else if (contents.getCost() > 2.0) {
			throw new PlatePriceException(); 
		}
	}


}
