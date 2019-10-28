package a6;

import java.util.ArrayList;
import java.util.Iterator;

public class PriceThresholdBeltIterator implements Iterator {

	private double maxPrice;
	private Belt belt;
	private Plate nextPlate;
	private boolean hasCalled;
	private int removePosition;
	private int startPosition;

	public PriceThresholdBeltIterator(Belt belt, int start_position, double max_price) {
		this.belt = belt;
		startPosition = start_position;
		maxPrice = max_price;
	}

	@Override
	public boolean hasNext() {
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(np(this.startPosition + i)) != null) { //if there is a plate in that position
				if (belt.getPlateAtPosition(np(this.startPosition + i)).getPrice() <= maxPrice) { //if the plate in that position is less than the max price
					nextPlate = belt.getPlateAtPosition(np(this.startPosition + i)); //sets next plate
					removePosition = np(this.startPosition + i); //index of remove position
					this.startPosition += i;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public Plate next() {
		hasCalled = true;
		if (!hasNext()) {
			throw new java.util.NoSuchElementException();
		} else {
			this.startPosition++;
			return nextPlate;
		}
	}

	public int np(int position) {
		int normalized_position = ((position % belt.getSize()) + belt.getSize()) % belt.getSize();
		return normalized_position;
	}
}
