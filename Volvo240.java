package lab1;

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25; //The trim factor specific for the Volvo 240
    
    // Creates a car with the Volvo 240 specifications
    public Volvo240(){
    	super(4, 100, Color.black, "Volvo240");
    }
    
    // Overrides the abstract method of the superclass. The speed factor varies with the trimFactor.
    @Override
    protected double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

}
