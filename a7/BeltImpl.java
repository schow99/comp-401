package a7;

import java.util.ArrayList;
import java.util.HashMap;

import a7.PlateEvent.EventType;
import comp401sushi.Plate;

public class BeltImpl implements Belt {

	private ArrayList<BeltObserver> beltObserver;
	private Plate[] _belt;
	private int belt_size;
	private Customer[] customers;

	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		this.belt_size = belt_size;
		beltObserver = new ArrayList<BeltObserver>();
		customers = new Customer[belt_size];
		_belt = new Plate[belt_size];

	}

	@Override
	public int getSize() {
		return _belt.length;
	}

	@Override
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}

	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}

		for (int i = 0; i < beltObserver.size(); i++) {
			beltObserver.get(i).handlePlateEvent(new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position));
		}

		_belt[position] = plate;
	}

	@Override
	public void clearPlateAtPosition(int position) {
		position = normalize_position(position);
		for (int i = 0; i < beltObserver.size(); i++) {
			beltObserver.get(i).handlePlateEvent(new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, this.getPlateAtPosition(position), position));
		}

		_belt[position] = null;
	}

	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}

	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position + offset);

				return normalize_position(position + offset);
			} catch (BeltPlateException e) {
				offset += 1;
			}
		}

		for (int i = 0; i < beltObserver.size(); i++) {
			beltObserver.get(i).handlePlateEvent(new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position));
		}
		throw new BeltFullException(this);
	}

	@Override
	public void rotate() {
		Plate last_plate = _belt[getSize() - 1];

		for (int i = 1; i < getSize(); i++) {
			_belt[i] = _belt[i - 1];
		}
		_belt[0] = last_plate;

		for (int i = 0; i < getSize(); i++) {
			if (customers[i] == null) {
				continue;
			} else {
				customers[i].observePlateOnBelt(this, this.getPlateAtPosition(i), i);
			}
		}
	}

	@Override
	public void addBeltObserver(BeltObserver o) {
		beltObserver.add(o);
	}

	@Override
	public void removeBeltObserver(BeltObserver o) {
		beltObserver.remove(o);
	}

	@Override
	public void registerCustomerAtPosition(Customer c, int position) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
		if (customers[normalize_position(position)] != null) {
			throw new RuntimeException();
		}
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] == null) {
				continue; 
			}
			else if (customers[i].equals(c) && i != normalize_position(position)) {
				throw new RuntimeException();
			}
		}
		customers[normalize_position(position)] = c;
	}

	@Override
	public Customer unregisterCustomerAtPosition(int position) {
		position = normalize_position(position);
		if (customers[position] == null) {
			return null;
		} else {
			Customer c = customers[position];
			customers[position] = null;
			return c;
		}

	}


}
