package models;

/**
 * Concrete class representing a First Class bogie.
 * First Class bogies are premium passenger bogies with premium seating.
 */
public class FirstClass extends PassengerBogie {

    /**
     * Constructor for creating a First Class bogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Number of seats
     */
    public FirstClass(String bogieId, int capacity) {
        super(bogieId, capacity, "First Class");
    }

    /**
     * Get details specific to First Class bogie
     * @return Detailed information about First Class configuration
     */
    @Override
    public String getDetails() {
        return String.format("First Class [%s] | Seats - Occupied: %d, Available: %d", 
            bogieId, seatsOccupied, seatsAvailable);
    }
}
