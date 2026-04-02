package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Train with its consist (collection of bogies).
 * Manages the composition and properties of the train.
 */
public class Train {
    private String trainId;
    private String engineType;
    private List<Bogie> consist;
    private int totalCapacity;

    /**
     * Constructor for creating a Train
     * @param trainId Unique identifier for the train
     * @param engineType Type of engine (e.g., "Diesel", "Electric")
     */
    public Train(String trainId, String engineType) {
        this.trainId = trainId;
        this.engineType = engineType;
        this.consist = new ArrayList<>();
        this.totalCapacity = 0;
    }

    /**
     * Get the train ID
     * @return Train identifier
     */
    public String getTrainId() {
        return trainId;
    }

    /**
     * Get the engine type
     * @return Engine type
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Add a bogie to the train consist
     * @param bogie Bogie to add
     * @return true if bogie is added successfully
     */
    public boolean addBogie(Bogie bogie) {
        if (bogie != null) {
            consist.add(bogie);
            totalCapacity += bogie.getCapacity();
            return true;
        }
        return false;
    }

    /**
     * Remove a bogie from the train consist
     * @param bogieId ID of the bogie to remove
     * @return true if bogie is removed successfully
     */
    public boolean removeBogie(String bogieId) {
        for (Bogie bogie : consist) {
            if (bogie.getBogieId().equals(bogieId)) {
                totalCapacity -= bogie.getCapacity();
                consist.remove(bogie);
                return true;
            }
        }
        return false;
    }

    /**
     * Get the number of bogies in the consist
     * @return Number of bogies
     */
    public int getConsistSize() {
        return consist.size();
    }

    /**
     * Get the total capacity of the train
     * @return Total capacity
     */
    public int getTotalCapacity() {
        return totalCapacity;
    }

    /**
     * Get the consist (list of bogies)
     * @return List of bogies
     */
    public List<Bogie> getConsist() {
        return new ArrayList<>(consist);
    }

    /**
     * Find a bogie by ID
     * @param bogieId ID to search for
     * @return Bogie if found, null otherwise
     */
    public Bogie findBogie(String bogieId) {
        for (Bogie bogie : consist) {
            if (bogie.getBogieId().equals(bogieId)) {
                return bogie;
            }
        }
        return null;
    }

    /**
     * Get string representation of the train
     * @return String representation
     */
    @Override
    public String toString() {
        return "Train{" +
                "trainId='" + trainId + '\'' +
                ", engineType='" + engineType + '\'' +
                ", bogies=" + consist.size() +
                ", totalCapacity=" + totalCapacity +
                '}';
    }
}
