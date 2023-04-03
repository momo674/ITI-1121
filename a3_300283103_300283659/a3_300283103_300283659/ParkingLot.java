/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {

	// IMPORTANT: You are *discouraged* from defining any new instance variables in
	// ParkingLot. You are expected to provide a list-based implementation of
	// ParkingLot. Defining new instance variables can take you away from this
	// implementation goal and thus result in the loss of marks.
	/**
	 * List for storing occupancy information in the lot
	 */
	private List<Spot> occupancy;

	/**
	 * The maximum number of cars that the lot can accommodate
	 */
	private int capacity;

	/**
	 * Constructs a parking lot with a given (maximum) capacity
	 * 
	 * @param capacity is the (maximum) capacity of the lot
	 */
	public ParkingLot(int capacity) {

		if (capacity <= 0) {
		
			throw new IllegalArgumentException("capcity must be greater than 0.");
		
		}

		this.capacity = capacity;
		this.occupancy = new SinglyLinkedList<Spot>();//maybe this is related to our error? it is an empty linked list after all. 
        //maybe we have to initialize the occupancy n stuff when we first take in a car, because until we do take in a car its just empty occupancy and will give that error
        //ok so after some more thinking we def need to mess around with occupancy. that's where the problem is. we need it to not be empty or at least not go to the SinglyLinkedList as empty, maybe some placeholder or a 0 value type thing idk im tired gn bbg
	}

	/**
	 * Parks a car (c) in the parking lot.
	 * 
	 * @param c         is the car to be parked
	 * @param timestamp is the (simulated) time when the car gets parked in the lot
	 */
	public void park(Car c, int timestamp) {
        if (this.occupancy.size() >= this.capacity) {
            throw new IllegalCallerException("Parking Lot is full, cannot add any more cars");
        }
        if (timestamp < 0) { throw new IllegalArgumentException ("Timestamp must be at least 0.") ;}
        if (c == null) { throw new NullPointerException("Car cannot be null! ") ;}
        if (this.attemptParking(c, timestamp)) {
            if (this.occupancy.isEmpty()){
                Spot created = new Spot(c, timestamp);
                this.occupancy.add(created);
            }
            else {
                Spot created = new Spot(c, timestamp);
                this.occupancy.add(created);
            }
        }
	  
	
	}

	/**
	 * Removes the car (spot) parked at list index i in the parking lot
	 * 
	 * @param i is the index of the car to be removed
	 * @return the car (spot) that has been removed
	 */
	public Spot remove(int i) {
    if (this.occupancy.isEmpty()) {
        throw new IllegalCallerException("Parking Lot is empty, there is nothing to remove.");
    }
    if (i < 0 || i >= this.occupancy.size()) { throw new IndexOutOfBoundsException(String.valueOf(i) + " cannot be used as an index.") ;}
	 Spot removed = this.occupancy.remove(i);
     return removed;
	
	}

	public boolean attemptParking(Car c, int timestamp) {
        // if (this.occupancy.size() >= this.capacity) {
        //     throw new IllegalCallerException("Parking Lot is full, cannot add any more cars.");
        // }
        if (c == null) {
            throw new NullPointerException("Car can't be null.");
        }

        if (timestamp < 0) {
            throw new IllegalArgumentException("timestamp must be greater than 0.");
        }

        if (this.occupancy.size() < this.capacity) { return true; }
       
        return false;
	}
    
	/**
	 * @return the capacity of the parking lot
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Returns the spot instance at a given position (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the spot instance at a given position (i, j)
	 */
	public Spot getSpotAt(int i) {
        if (i < 0  || i >= this.capacity || i >= this.occupancy.size()) { //|| i >= this.occupancy.size()
            throw new IndexOutOfBoundsException(String.valueOf(i) + " cannot be used as an index.");
        }
        
        
		return this.occupancy.get(i);

	}

	/**
	 * @return the total number of cars parked in the lot
	 */
	public int getOccupancy() {
        return this.occupancy.size();
	}

	/**
	 * @return String representation of the parking lot
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Total capacity: " + this.capacity + System.lineSeparator());
		buffer.append("Total occupancy: " + this.occupancy.size() + System.lineSeparator());
		buffer.append("Cars parked in the lot: " + this.occupancy + System.lineSeparator());

		return buffer.toString();
	}
}