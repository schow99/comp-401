package a6;

import java.util.ArrayList;
import java.util.Iterator;

import a6.Plate.Color;

public class ColorFilteredBeltIterator implements Iterator {

	private int startPosition;
	private Belt belt;
	private Plate nextPlate;
	private boolean hasCalled;
	private int removePosition;
	private Plate.Color color;

	public ColorFilteredBeltIterator(Belt belt, int start_position, Plate.Color color_filter) {
		this.belt = belt;
		startPosition = start_position;
		color = color_filter;
	}

	@Override
	public boolean hasNext() {
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(np(this.startPosition + i)) != null) { //if there is a plate in that position
				if (belt.getPlateAtPosition(np(this.startPosition + i)).getColor().equals(color)) { //if the color of the plate is the same as the parameter
					nextPlate = belt.getPlateAtPosition(np(this.startPosition + i)); //sets next plate 
					removePosition = np(this.startPosition + i); //gets index for remove position
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
