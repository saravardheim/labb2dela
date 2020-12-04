package lab1;

import java.util.ArrayList;

public class Garage <T extends Car>{
	
	private ArrayList<T> inventory;
	private int capacity;
	
	// Creates a garage that can handle any type of car
	public Garage(int capacity) {
		inventory = new ArrayList<T>();
		this.capacity = capacity;
	}
	
	// Adds car to garage inventory, if it's not full
	public void recieveCar(T car) {
		if (inventory.size() >= capacity)
			throw new IllegalArgumentException();
		inventory.add(car);		
	}
	
	// Removes car from inventory, if it is in the inventory and the inventory is not empty
	public void returnCar(T car) {
		if (inventory.isEmpty())
			throw new NullPointerException();
		else if (!inventory.contains(car))
			throw new IllegalArgumentException();
		inventory.remove(car);
	}
}
