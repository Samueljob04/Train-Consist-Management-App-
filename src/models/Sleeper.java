package models;

/**
 * Concrete class representing a Sleeper bogie.
 * Sleeper bogies are passenger bogies with berth-style sleeping accommodation.
 */
public class Sleeper extends PassengerBogie {

    /**
     * Constructor for creating a Sleeper bogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Number of berths/seats
     */
    public Sleeper(String bogieId, int capacity) {
        super(bogieId, capacity, "Sleeper");
    }

    /**
     * Get details specific to Sleeper bogie
     * @return Detailed information about sleeper configuration
     */
    @Override
    public String getDetails() {
        return String.format("Sleeper [%s] | Berths - Occupied: %d, Available: %d", 
            bogieId, seatsOccupied, seatsAvailable);
    }
}
