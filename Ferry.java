package lab1;

import java.awt.Color;

public class Ferry extends Vehicle {
	
	private Transporter<Car> transporter;
	private Ramp ramp;
	Car load;
	
	public Ferry(int capacity) {
		super(50, Color.white, "Car Ferry") ;
		transporter = new Transporter<Car>(capacity, true);
		ramp = new Ramp(30);
	}
	
	// The ramp can be either up or down, no inbetween
	public void setUpOrDown(boolean up) {
		if (this.getCurrentSpeed() == 0) {
			if (up)
				ramp.rampUp();
			else 
				ramp.rampDown();
		}
		else
			throw new IllegalArgumentException();
	}
	
	// A car boards the transporter if it's nearby, the ramp is down and the transporter is not full
	// The car cannot board the transporter if it's already being transported
	public void board(Car car) {
		if ((!nearby(car) && ramp.getAngle() == 0) || car.getTransported())
			throw new IllegalArgumentException();
		transporter.load(car);
		car.setTransported(true);
	}
	
	// Unloads a car from the transporter if the ramp is down and the transporter is not empty
	public void unload() {
		if (ramp.getAngle() == 0)
			throw new IllegalArgumentException();
		transporter.unload();
		transporter.unloaded.moveNearby();
	}
	
	// @returns the number of cars already loaded on the ferry
	public int nrLoaded() {
		return transporter.nrLoaded();
	}

	// Moves every loaded car to the position of the car transporter
	@Override
	public void move() {
		if (ramp.getAngle() == 0) {
			super.move();
			for (Car c : transporter.loadedGoods()) {
				c.setPosition(this.getPosition());
			}			
		}
	}
	
	// Overrides the method of the superclass
	@Override
	protected double speedFactor() {
		return this.getEnginePower() * 0.008;
	}
}
