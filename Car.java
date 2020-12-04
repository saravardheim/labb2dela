package lab1;

import java.awt.Color;

public abstract class Car extends Vehicle implements Transportable {

    private int nrDoors; // Number of doors on the car
    private boolean transported; //Marks whether or not the car is being transported
    
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
    	super(enginePower, color, modelName);
    	this.nrDoors = nrDoors ;
    	transported = false;
	}
	
    // Returns the number of doors on the car
	public int getNrDoors(){
        return nrDoors;
    }
	
	@Override
	public void gas(double amount) {
		if (transported)
			throw new IllegalArgumentException();
		super.gas(amount);
	}
	
	@Override
	public void brake (double amount) {
		if (transported)
			throw new IllegalArgumentException();
		super.brake(amount);
	}
	
	// Changes the transported state of the car
	@Override
	public void setTransported(boolean transport) {
		transported = transport;
	}
	
	// Returns the transported state of the car
	@Override
	public boolean getTransported() {
		return transported;
	}
}
    
