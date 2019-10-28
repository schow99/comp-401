package a7;

public class ProfitCounter implements BeltObserver{
	private double profit; 
	private Belt b; 
	
	public ProfitCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException(); 
		}
		b.addBeltObserver(this); 
		this.b = b; 
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) == null) {
				continue; 
			}
			profit += b.getPlateAtPosition(i).getProfit(); 
		}
	}
	
	public double getTotalBeltProfit() {
		return profit; 
	}
	
	public double getAverageBeltProfit() {
		if (b.getSize() == 0) {
			return 0.0; 
		}
		int counter = 0; 
		
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) != null) {
				counter++;
			}
		}
		if (counter == 0) {
			return 0.0; 
		}
		return profit / counter ; 
	}

	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getType() == (PlateEvent.EventType.PLATE_PLACED)) {
			profit = profit + e.getPlate().getProfit(); 
		} else {
			profit = profit - e.getPlate().getProfit(); 
		}
	}

 
}
