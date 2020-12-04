package lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
            	int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                if ( x >= 700 || x <= -1) {
                	car.turnLeft();
                	car.turnLeft();
                }           
                car.move();
                x = (int) Math.round(car.getPosition().getX());
                y = (int) Math.round(car.getPosition().getY());
    
                frame.drawPanel.moveit(x, y, cars.indexOf(car));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }
    
    // Calls the brake method for each car once
    void brake(int amount) {
    	double brake = ((double) amount) / 100;
    	for (Car car : cars)
    		car.brake(brake);
    }
    
    //Stops all cars, using Vehicle stopEngine method
    void stopCars() {
    	for (Car car : cars) {
    		car.stopEngine();
    	} 	
    }
    
  //Starts all cars, using Vehicle startEngine method
    void startCars() {
    	for (Car car : cars) {
    		car.startEngine();
    	}
    }
    
    //Turns on turbo for every Saab95 in cars
    void turboOn() {
    	Saab95 saab = new Saab95();
    	for (Car car : cars) {
    		if (car.getClass() == saab.getClass()) {
    			((Saab95) car).setTurboOn();
    		}
    	}
    }
    
    //Turns off turbo for every Saab95 in cars
    void turboOff() {
    	Saab95 saab = new Saab95();
    	for (Car car : cars) {
    		if (car.getClass() == saab.getClass()) {
    			((Saab95) car).setTurboOff();
    		}
    	}
    }
    // Lifts the bed to top position for every Scania in cars
    void liftBed() {
    	Scania scania = new Scania();
    	for (Car car : cars) {
    		if (car.getClass() == scania.getClass()) {
    			((Scania) car).setRampAngle(70);
    		}
    	}
    }
    
    // Lowers the truck bed to lowest position for every Scania in cars
    void lowerBed() {
    	Scania scania = new Scania();
    	for (Car car : cars) {
    		if (car.getClass() == scania.getClass()) {
    			((Scania) car).setRampAngle(0);
    		}
    	}
    }
}

