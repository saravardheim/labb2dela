package lab1;

import java.awt.Color;
import java.awt.geom.Point2D;

import javax.management.InvalidAttributeValueException;

public abstract class  Vehicle implements Movable{

	private Point2D.Double position = new Point2D.Double(); // The (x,y) coordinates of the car
    private int direction = 0; //The direction of the moving car, starting along the positive x-axis
    private double currentSpeed; // The current speed of the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    
    public Vehicle(double enginePower, Color color, String modelName) {
    	this.enginePower = enginePower;
    	this.color = color;
    	this.modelName = modelName;
    	stopEngine();
    }
    
	// Returns the current speed of the car
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    
	// Returns the engine power of the car
	public double getEnginePower() {
		return enginePower;
	}
    
    // Returns the color of the car
    public Color getColor(){
        return color;
    }
    
    // Sets the color of the car
    public void setColor(Color clr){
    	if (clr == null)
    		throw new IllegalArgumentException();
	    color = clr;
    }
    
    // Returns the model name of the car
    public String getModelName() {
    	return modelName;
    }
    
    // "Starts the engine", sets the current speed of the car to 0.1
    public void startEngine(){
	    currentSpeed = 0.1;
    }
    
    // "Stops the engine", sets the current speed of the car to 0
    public void stopEngine(){
	    currentSpeed = 0;
    }
    /**
     * Increments the speed of the car by adding the preferred amount to the current speed,
     * if this action does not make the current speed exceed the engine power. Used by the gas method.
     */
    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(currentSpeed + speedFactor() * amount,enginePower);
    }
    
    /** Decrements the speed of the car by subtracting the preferred amount from the current speed,
     * if this action does not make the current speed fall below 0. Used by the brake method.
     */
    private void decrementSpeed(double amount) {
    	currentSpeed = Math.max(currentSpeed - speedFactor() * amount,0);
    }
    
    /** 
     * Uses incrementSpeed, but can only gas with a factor [0,1]. Throws exception if amount entered
     * exceeds 1 or falls below 0.
     * @param amount
     * @throws InvalidAttributeValueException
     */
    public void gas(double amount) {
    	if (amount > 1 || amount < 0)
    		throw new IllegalArgumentException(); 
        incrementSpeed(amount);
    }
    
    /** 
     * Uses decrementSpeed, but can only brake with a factor [0,1]. Throws exception if amount entered
     * exceeds 1 or falls below 0.
     * @param amount
     * @throws InvalidAttributeValueException
     */
    public void brake(double amount) {
    	if (amount > 1 || amount < 0)
    		throw new IllegalArgumentException();
    	decrementSpeed(amount);
    }   

	/**
     *  Moves the vehicle with its current speed. The direction is 0 along positive x-axis, 1 along negative
     *  y-axis, 2 along negative x-axis and 3 along positive y-axis. The integer direction is
     *  growing when the vehicle turns clockwise.
     */
	@Override
    public void move() {
    	switch(direction) {
    	case 0:
    		position.x += currentSpeed;
    		break;
    	case 1:
    		position.y -= currentSpeed;
    		break;
    	case 2:
    		position.x -= currentSpeed;
    		break;
    	case 3:
    		position.y += currentSpeed;
    		break;
    	}
    }
  
    protected void moveNearby() {
    	this.position.x += 1 ;
    	this.position.y += 1 ;
    }
    
    // Returns true if the vehicle is no more than 1 point in x or y away from the other vehicle
 	public boolean nearby(Vehicle vehic) {
 		return Math.abs(this.getPosition().x - vehic.getPosition().x) < 1 && Math.abs(this.getPosition().y - vehic.getPosition().y) < 1 ;
 	}
    
    /**
     *  Turns the vehicle left. Since the direction is 0 along the positive x-axis and 0-1 =/= 3 (which is the
     *  notation for direction along the postive y-axis), the direction is set to 3 if direction = 0
     */
    @Override
	public void turnLeft() {
		if (direction == 0)
			direction = 3;
		else
			direction -= 1;
	}
	
	 /**
     *  Turns the vehicle right. Since the direction is 3 along the positive y-axis and 3+1 =/= 0 (which is the
     *  notation for direction along the postive x-axis), the direction is set to 0 if direction = 3
     */
    @Override
	public void turnRight() {
		if (direction == 3)
			direction = 0;
		else
			direction += 1;
	}
	
	public int getDirection() {
		return direction;
	}
	
	// Returns the position of the vehicle, starting at (0,0)
	public Point2D.Double getPosition() {
		return position;
	}
	
	// Sets the position of the vehicle
	protected void setPosition(Point2D.Double position) {
		this.position = position;
	}
	
	// This method differs between different types of cars and is therefore abstract.
    protected abstract double speedFactor();
    

}
