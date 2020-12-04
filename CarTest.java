package lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.geom.Point2D;

import org.junit.jupiter.api.Test;

class CarTest {
	
	Volvo240 volvo = new Volvo240();
	Saab95 saab = new Saab95();
	Scania scania = new Scania();
	CarTransport carTransport = new CarTransport(5);
	Ferry ferry = new Ferry(100);
	
	//Calculated by hand
	@Test
	void testSetTurbo() {
		saab.setTurboOn();
        assertTrue(saab.speedFactor() == 1.625);
        saab.setTurboOff();
        assertTrue(saab.speedFactor() == 1.25);
	}

	@Test
	void testGetNrDoors() {
		assertTrue(volvo.getNrDoors() == 4);
		assertTrue(saab.getNrDoors() == 2);	
	}

	@Test
	void testGetEnginePower() {
		assertTrue(volvo.getEnginePower() == 100);
		assertTrue(saab.getEnginePower() == 125);	
	}

	@Test
	void testGetCurrentSpeed() {
		Volvo240 volvo2 = new Volvo240();
		assertTrue(volvo2.getCurrentSpeed() == 0);
	}

	@Test
	void testGetColor() {
		assertTrue(volvo.getColor() == Color.black);
	}

	// If getColor works
	@Test
	void testSetColor() {
		Volvo240 volvo2 = new Volvo240();
		volvo2.setColor(Color.CYAN);
		assertTrue(volvo2.getColor() == Color.CYAN);
	}

	@Test
	void testStartEngine() {
		volvo.startEngine();
		assertTrue(volvo.getCurrentSpeed() == 0.1);
	}

	@Test
	void testStopEngine() {
		volvo.stopEngine();
		assertTrue(volvo.getCurrentSpeed() == 0);
	}

	@Test
	void testGas() {
		double start = volvo.getCurrentSpeed();
		volvo.gas(1);
		assertTrue(start < volvo.getCurrentSpeed());		
	}

	@Test
	void testBrake() {
		volvo.startEngine();
		double start = volvo.getCurrentSpeed();
		volvo.brake(1);
		assertTrue(start > volvo.getCurrentSpeed());
	}

	@Test
	void testMove() {
		volvo.stopEngine(); //Makes sure the car is stopped when test begins
		Point2D.Double point = volvo.getPosition(); //should be (0,0) at start
		volvo.gas(1); volvo.move();
		assertTrue(volvo.getPosition().equals(point)); //These will not be equal
	}

	@Test
	void testTurnLeft() {
		Volvo240 volvo2 = new Volvo240();
		volvo2.turnLeft();
		assertTrue(volvo2.getDirection() == 3);	
	}

	@Test
	void testTurnRight() {
		Volvo240 volvo2 = new Volvo240();
		volvo2.turnRight();
		assertTrue(volvo2.getDirection() == 1);
	}
	
	@Test
	void testIncreaseAngle () {
		scania.increaseAngle(30);
		assertTrue(scania.getRampAngle() == 30);
	}
	
	@Test
	void testRampDown() {
		carTransport.setRampAngle(70);
		assertTrue(carTransport.getRampAngle() == 70);
	}
	
	@Test
	void testFerryBoard() {
		ferry.setUpOrDown(false);
		int loaded = ferry.nrLoaded();
		ferry.board(volvo);
		assertTrue(loaded > ferry.nrLoaded());
	}
}
