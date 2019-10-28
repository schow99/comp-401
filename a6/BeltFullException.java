package a6;

public class BeltFullException extends Exception {
	public BeltFullException(Belt belt) {
		super("Belt is full");
	}

}
