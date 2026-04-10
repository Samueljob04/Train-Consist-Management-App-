package models;

/**
 * Abstract class representing a passenger bogie with seat tracking capabilities.
 * Extends Bogie class with passenger-specific attributes.
 */
public abstract class PassengerBogie extends Bogie {
    protected int seatsOccupied;
    protected int seatsAvailable;

    /**
     * Constructor for creating a PassengerBogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Maximum seat capacity
     * @param type Type of passenger bogie (e.g., "Sleeper", "AC Chair", "First Class")
     * @throws InvalidBogieCapacityException when capacity is not positive
     */
    public PassengerBogie(String bogieId, int capacity, String type) {
        super(bogieId, capacity, type);
        if (capacity <= 0) {
            throw new InvalidBogieCapacityException("Invalid passenger bogie capacity: " + capacity);
        }
        this.seatsOccupied = 0;
        this.seatsAvailable = capacity;
    }

    /**
     * Get the number of occupied seats
     * @return Number of occupied seats
     */
    public int getSeatsOccupied() {
        return seatsOccupied;
    }

    /**
     * Get the number of available seats
     * @return Number of available seats
     */
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    /**
     * Book seats in the bogie
     * @param seatCount Number of seats to book
     * @return true if booking is successful, false otherwise
     */
    public boolean bookSeats(int seatCount) {
        if (seatCount <= seatsAvailable && seatCount > 0) {
            seatsOccupied += seatCount;
            seatsAvailable -= seatCount;
            return true;
        }
        return false;
    }

    /**
     * Get string representation of passenger bogie details
     * @return String with seat information
     */
    @Override
    public String getDetails() {
        return String.format("%s | Seats - Occupied: %d, Available: %d", 
            toString(), seatsOccupied, seatsAvailable);
    }
}
