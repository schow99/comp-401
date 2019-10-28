package a6;

public interface Plate {
	public enum Color {RED, GREEN, BLUE, GOLD};
	Sushi getContents(); 
	Sushi removeContents(); 
	void setContents(Sushi s) throws PlatePriceException; 
	boolean hasContents(); 
	double getPrice(); 
	a6.PlateImpl.Color getColor(); 
	double getProfit(); 


}
