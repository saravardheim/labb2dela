package lab1;

import java.awt.Color;

public class Scania extends Truck{
	
	public Scania() {
		super(2, 100, Color.white, "Scania");
	}

	//Increases the angle of the truck bed, if the truck is not moving. The maximum angle of the bed is 70
	public void increaseAngle(int amount) {
		if (amount < 0 || this.getCurrentSpeed() != 0)
			throw new IllegalArgumentException();
		else if (super.getRampAngle() + amount > 70)
			super.setRampAngle(70);
		else
			super.setRampAngle(this.getRampAngle() + amount);
			}
			
	//Decreases the angle of the truck bed, if the truck is not moving. The minimum angle of the bed is 0
	public void decreaseAngle(int amount ) {
		if (amount < 0 || this.getCurrentSpeed() != 0)
			throw new IllegalArgumentException();
		else if (super.getRampAngle() - amount < 0)
			super.setRampAngle(0); 
		else
			super.setRampAngle(super.getRampAngle() - amount);
	}
		
}
