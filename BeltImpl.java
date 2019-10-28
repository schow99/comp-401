package a6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import a6.Plate.Color;

public class BeltImpl implements Belt {
	private int belt_size;
	private Plate[] plates;

	public BeltImpl(int belt_size) {
		this.belt_size = belt_size;
		plates = new Plate[belt_size];
		if (belt_size <= 0) {
			throw new IllegalArgumentException("Belt size cannot be less than or equal to 0"); 
		}
	}

	@Override
	public int getSize() {
		return this.belt_size;
	}

	@Override
	public Plate getPlateAtPosition(int position) {
		return plates[np(position)];
	}

	/*
	 * Sets a plate at the specified position on the belt. If the provided plate is
	 * null, throws an IllegalArgumentException. If there is already a plate at that
	 * position, throws a BeltPlateException.
	 */
	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) { 
			throw new IllegalArgumentException("Plate cannot be null");
		}
		if (plates[np(position)] != null) { //if there is something in that position
			throw new BeltPlateException(position, plate, this);
		} else {
			plates[np(position)] = plate;
		}
	}

	@Override
	public void clearPlateAtPosition(int position) {
		plates[np(position)] = null; //takes position and clears that spot
	}

	@Override
	public Plate removePlateAtPosition(int position) {
		if (plates[position] == null) { //if there is no plate at position
			throw new java.util.NoSuchElementException();
		}
		Plate removedPlate = getPlateAtPosition(position); //gets the plate at the given position
		clearPlateAtPosition(position); //clears plate at that position
		return removedPlate; //return removed plate
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		for (int i = 0; i < belt_size; i++) {
			if (plates[np(position + i)] == null) { //finds the next spot where belt is empty 
				plates[np(position + i)] = plate; //set plate to that spot
				return np(position + i); 
			}
		}
		throw new BeltFullException(this);
	}

	@Override
	public Iterator iterator() {
		BeltIterator iterator = new BeltIterator(this, 0);
		return iterator;
	}

	@Override
	public Iterator iteratorFromPosition(int position) {
		BeltIterator iterator = new BeltIterator(this, position);
		return iterator;
	}
	
	public void rotate() {
		LinkedList<Plate> rotated = new LinkedList<Plate>(Arrays.asList(plates)); //turn array into linkedlist
		Plate last = rotated.getLast(); //gets last item in the linkedlist
		rotated.add(0, last); //adds the last item to the beginning
		rotated.remove(belt_size); //removes last plate
		this.plates = rotated.toArray(new Plate[rotated.size()]); //turns linked list back into array
	}
	
	public int np(int position) {
		int normalized_position = ((position % belt_size) + belt_size) % belt_size;
		return normalized_position; 
	}

	@Override
	public Iterator<Plate> iterator(double max_price) {
		PriceThresholdBeltIterator plates = new PriceThresholdBeltIterator(this, 0, max_price);
		return plates; 
	}

	@Override
	public Iterator<Plate> iterator(Color color) {
		ColorFilteredBeltIterator plates = new ColorFilteredBeltIterator(this, 0, color);
		return plates; 
	}

	@Override
	public Iterator<Plate> iteratorFromPosition(int position, double max_price) {
		PriceThresholdBeltIterator plates = new PriceThresholdBeltIterator(this, position, max_price);
		return plates; 
	}

	@Override
	public Iterator<Plate> iteratorFromPosition(int position, Color color) {
		ColorFilteredBeltIterator plates = new ColorFilteredBeltIterator(this, position, color);
		return plates; 
	}

}
