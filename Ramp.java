package lab1;

public class Ramp {
	
	private int rampAngle, maxAngle;

	public Ramp(int maxAngle) {
		this.rampAngle = 0;
		this.maxAngle = maxAngle;
	}
	
	// Returns the angle of the truck bed
	public int getAngle() {
		return rampAngle;
	}
	
	// Sets the angle of the truck bed, with max/min angle 70/0 degrees
	public void setAngle(int angle) {
		if (angle < 0)
			throw new IllegalArgumentException();
		rampAngle = angle ;
	}
	
	// Moves the truck's ramp up if the truck is not moving
	public void rampUp() {
		setAngle(0);
	}	
	/**
	 *  Moves the truck's ramp down if the truck is not moving.
	 *  The angle is measured from the truck bed to the ground
	 */
	public void rampDown() {
		setAngle(maxAngle);
	}
	
}
