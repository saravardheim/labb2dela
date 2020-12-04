package lab1;

import java.util.Deque;

public class Transporter<T extends Transportable> {
	
	private int maxCapacity ;
	private Deque<T> loaded;
	boolean fifo;
	T unloaded;

	// Creates new transporter with a max capacity and fifo or lifo
	public Transporter( int maxCapacity, boolean fifo) {
		this.maxCapacity = maxCapacity;	
		this.fifo = fifo;
	}
		
	// An element boards the transporter if the transporter is not full
	public void load(T load) {
		if (loaded.size() < maxCapacity || loaded.isEmpty()) {
			loaded.addFirst(load);	
		}
		else
			throw new IllegalArgumentException();
	}	
		
	// Unloads an element from the transporter if  the it is not empty
	public T unload() {
		if (loaded.isEmpty())
			throw new NullPointerException();
		if (fifo) {
			unloaded = loaded.peekLast();
			loaded.removeLast();
		}
		else {
			unloaded = loaded.peekLast();
			loaded.removeFirst();
		}
		return unloaded;
	}
	
	// Returns the number of transportables loaded on the transporter
	public int nrLoaded() {
			return loaded.size();
	}	
	
	// Returns the deque of loaded transportables
	public Deque<T> loadedGoods() {
		return loaded ;
	}
}
