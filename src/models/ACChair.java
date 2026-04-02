package models;

/**
 * Concrete class representing an AC Chair Car bogie.
 * AC Chair bogies are passenger bogies with air-conditioned chair seating.
 */
public class ACChair extends PassengerBogie {

    /**
     * Constructor for creating an AC Chair bogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Number of seats
     */
    public ACChair(String bogieId, int capacity) {
        super(bogieId, capacity, "AC Chair");
    }

    /**
     * Get details specific to AC Chair bogie
     * @return Detailed information about AC Chair configuration
     */
    @Override
    public String getDetails() {
        return String.format("AC Chair [%s] | Seats - Occupied: %d, Available: %d", 
            bogieId, seatsOccupied, seatsAvailable);
    }
}
