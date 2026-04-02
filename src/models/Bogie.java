package models;

/**
 * Abstract base class representing a bogie (railway car) in the train consist.
 * A bogie is a truck with wheels that forms part of a train.
 */
public abstract class Bogie {
    protected String bogieId;
    protected int capacity;
    protected String type;

    /**
     * Constructor for creating a Bogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Maximum capacity of the bogie
     * @param type Type of bogie (e.g., "Sleeper", "AC Chair", "Rectangular Goods")
     */
    public Bogie(String bogieId, int capacity, String type) {
        this.bogieId = bogieId;
        this.capacity = capacity;
        this.type = type;
    }

    /**
     * Get the bogie ID
     * @return Bogie identifier
     */
    public String getBogieId() {
        return bogieId;
    }

    /**
     * Get the capacity of the bogie
     * @return Maximum capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Get the type of bogie
     * @return Type identifier
     */
    public String getType() {
        return type;
    }

    /**
     * Abstract method to get details of the bogie
     * @return String representation of bogie details
     */
    public abstract String getDetails();

    /**
     * Get string representation of the bogie
     * @return String representation
     */
    @Override
    public String toString() {
        return "Bogie{" +
                "bogieId='" + bogieId + '\'' +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}
