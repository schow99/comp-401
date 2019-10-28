package a6;

public class PlateImpl implements Plate {

	double price;
	Sushi plate;
	Plate.Color color;

	public PlateImpl(Sushi plate, double price, Plate.Color color) { // constructor for PlateImpl
		this.plate = plate;
		this.price = price;
		this.color = color;
	}

	@Override
	public Sushi getContents() { // gets contents from sushi plate
		if (this.plate == null) {
			return null;
		}
		return this.plate;
	}

	@Override
	public Sushi removeContents() { // returns the sushi plate but empties the plate as well
		if (this.plate == null) {
			return null;
		}
		Sushi newPlate = this.plate;
		this.plate = null;
		return newPlate;
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException { // sets new contents for sushi plate
		if (s == null) {
			throw new IllegalArgumentException("s cannot be null"); // must have contents in sushi plate
		}
		else if (this.price <= s.getCost()) { // checks if the inputed price is less than the price of the entire plate
			throw new PlatePriceException();
		}
		else {
			this.plate = s;
		}
	}

	@Override
	public boolean hasContents() { // checks if plate is empty
		if (this.plate == null) {
			return false;
		}
		return true;
	}

	@Override
	public double getPrice() {
		return this.price; 
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public double getProfit() {
		if (this.plate == null) {
			return 0.0;
		} else {
		return getPrice() - getContents().getCost() - 0.07; // returns the profit by subtracting plate cost from price
		}
	}

}
