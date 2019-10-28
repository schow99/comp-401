package a6;

import java.util.Iterator;

public class BeltIterator implements Iterator {
	private Belt belt;
	private int start_position;
	private Plate nextPlate;
	private boolean hasCalled;
	private int removePosition;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = start_position;
	}

	public boolean hasNext() {
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(np(this.start_position + i)) != null) { //if the position is not null
				nextPlate = belt.getPlateAtPosition(np(this.start_position + i)); //set that position as the next plate
				removePosition = np(this.start_position + i);//the index of the remove position
				this.start_position += i; //updates the next start position
				return true;
			}
		}

		return false;
	}

	public Plate next() {
		hasCalled = true; //ensures that hasNext has been called
		if (!hasNext()) { //calls has next
			throw new java.util.NoSuchElementException();
		} else {
			this.start_position++; //increments start position so that it changes
			return nextPlate; //returns the next plate 
		}
	}

	public void remove() {
		if (!hasCalled) {
			throw new IllegalStateException();
		}
		belt.removePlateAtPosition(removePosition); //remove the plate at the remove index
		hasCalled = false;
	}

	public int np(int position) {
		int normalized_position = ((position % belt.getSize()) + belt.getSize()) % belt.getSize();
		return normalized_position;
	}

}
