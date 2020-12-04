package lab1;

public interface Movable {
	
	/**
	 * The methods are public in the classes that implement the interface. These are the methods that will
	 * be called by a user and therefore they are public.
	 */
	
	// Moves the object that implements the interface
	public void move();
	
	// Turns the object left
	public void turnLeft();
	
	// Turns the object right
	public void turnRight();
	
}
