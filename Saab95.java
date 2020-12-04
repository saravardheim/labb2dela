package lab1;

import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn; // True if turbo is on, false if not.
    
    // Creates a car with the Saab 9-5 specifications
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;
    }
    
    // Turns on the turbo, sets turboOn to true
    public void setTurboOn(){
	    turboOn = true;
    }

    // Turns off the turbo, sets turboOn to false
    public void setTurboOff(){
	    turboOn = false;
    }
    
    /**
     * Overrides the abstract method of the superclass. The speed factor varies if the turbo is on/off,
     * and the method tests if turboOn is true/false.
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
    
}
