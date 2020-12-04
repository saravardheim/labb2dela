package lab1;

import java.awt.Color;

public class CarTransport implements Movable{
	
	private Transporter<Car> transporter;
	private Truck thisTransporter;
	
	public CarTransport(int capacity) {
		thisTransporter = new Truck(2, 100, Color.white, "Car Transport");
		transporter = new Transporter<Car>(capacity, false);
	}
	
	// Uses Truck's setRampAngle to define the car transporters ability to only have ramp up or down
	public void setRampAngle(int angle) {
		if (angle == 0)
			thisTransporter.setRampAngle(angle);
		else if (angle == 70)
			thisTransporter.setRampAngle(angle);
		else
			throw new IllegalArgumentException();
	}
	
	// Uses Truck's getRampAngle to return the angle of the the ramp
	public int getRampAngle() {
		return thisTransporter.getRampAngle();
	}
	
	// A car boards the transporter if it's nearby, the ramp is down and the transporter is not full
	// The car cannot board the transporter if it's already being transported
	public void board(Car car) {
		if ((!thisTransporter.nearby(car) && thisTransporter.getRampAngle() == 0) || car.getTransported())
			throw new IllegalArgumentException();
		transporter.load(car);
		car.setTransported(true);
	}	
	
	// Unloads a car from the transporter if the ramp is down and the transporter is not empty
	public void unload() {
		if (thisTransporter.getRampAngle() == 0)
			throw new IllegalArgumentException();
		transporter.unload();
		transporter.unloaded.moveNearby();
		transporter.unloaded.setTransported(false);
	}
	
	// Returns the number of cars already loaded on the truck
	public int nrLoaded() {
		return transporter.nrLoaded();
	}
	
	// Moves every loaded car to the position of the car transporter
	@Override
	public void move() {
		if (thisTransporter.getRampAngle() == 0) {
			thisTransporter.move();
			for (Car c : transporter.loadedGoods()) {
				c.setPosition(thisTransporter.getPosition());
			}			
		}
	}
	
	// Uses the implementation of turnLeft in the Truck class
	@Override
	public void turnLeft() {
		thisTransporter.turnLeft();		
	}
	
	// Uses the implementation of turnRight in the Truck class
	@Override
	public void turnRight() {
		thisTransporter.turnRight();	
	}	
}
