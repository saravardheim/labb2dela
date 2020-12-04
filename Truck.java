package lab1;

import java.awt.Color;

public class Truck extends Car{
	
	private Ramp ramp;
	
	public Truck(int nrDoors, double enginePower, Color color, String modelName) {
		super(nrDoors, enginePower, color, modelName);
		ramp = new Ramp(70);
		ramp.setAngle(0);
	}
	
	// Sets the angle of the truck bed, if the truck is not moving
	public void setRampAngle(int angle) {
		if ((angle < 0 || angle > 70 || super.getCurrentSpeed() != 0) && angle != ramp.getAngle())
			throw new IllegalArgumentException();
		else 
			ramp.setAngle(angle); ;
	}
	
	// Returns the angle of the truck ramp
	public int getRampAngle() {
		return ramp.getAngle();
	}
		
	// The truck can not increase its current speed if the truck bed angle is more than 0
	@Override
	public void gas(double amount) {
		if (ramp.getAngle() != 0)
			throw new IllegalArgumentException();
		else
			super.gas(amount);
	}
		
	// The truck can not start its engine if the truck bed angle is more than 0
	@Override
	public void startEngine() {
		if (ramp.getAngle() != 0)
			throw new IllegalArgumentException();
		else
			super.startEngine();
	}
	
	// Overrides the abstract method of the superclass.
	@Override
	protected double speedFactor() {
		return this.getEnginePower() * 0.01 ;
	}
}
