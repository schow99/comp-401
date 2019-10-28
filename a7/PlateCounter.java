package a7; 

import java.util.HashMap;

import comp401sushi.Plate;

public class PlateCounter implements BeltObserver {

	private int blueCount;
	private int redCount;
	private int greenCount;
	private int goldCount;

	public PlateCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		b.addBeltObserver(this); 
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) == null) {
				continue; 
			}
			switch (b.getPlateAtPosition(i).getColor()) {
			case BLUE:
				blueCount++;
				break;
			case RED:
				redCount++;
				break;
			case GREEN:
				greenCount++;
				break;
			case GOLD:
				goldCount++;
				break;
			}

		}
	}

	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getType() == (PlateEvent.EventType.PLATE_PLACED)) {
			switch (e.getPlate().getColor()) {
			case BLUE:
				blueCount++;
				break;
			case RED:
				redCount++;
				break;
			case GREEN:
				greenCount++;
				break;
			case GOLD:
				goldCount++;
				break;
			}
		} else {
			switch (e.getPlate().getColor()) {
			case BLUE:
				blueCount--;
				break;
			case RED:
				redCount--;
				break;
			case GREEN:
				greenCount--;
				break;
			case GOLD:
				goldCount--;
				break;
			}
		}
	}

	public int getRedPlateCount() {
		return redCount;
	}

	public int getGreenPlateCount() {
		return greenCount;
	}

	public int getBluePlateCount() {
		return blueCount;
	}

	public int getGoldPlateCount() {
		return goldCount;
	}

}
