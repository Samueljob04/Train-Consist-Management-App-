package models;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a Train with its consist (collection of bogies).
 * Manages the composition and properties of the train.
 */
public class Train {
    private String trainId;
    private String engineType;
    private List<Bogie> consist;
    private int totalCapacity;
    private Set<String> bogieIds; // track unique bogie IDs to prevent duplicates

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
        this.bogieIds = new HashSet<>();
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
     * Ensures bogie IDs remain unique across the train (UC3)
     * @param bogie Bogie to add
     * @return true if bogie is added successfully, false if null or duplicate ID
     */
    public boolean addBogie(Bogie bogie) {
        if (bogie == null) {
            return false;
        }
        String id = bogie.getBogieId();
        if (id == null || id.isEmpty()) {
            return false; // invalid ID
        }
        // Enforce uniqueness
        if (bogieIds.contains(id)) {
            return false; // duplicate ID - reject
        }
        // add
        consist.add(bogie);
        bogieIds.add(id);
        totalCapacity += bogie.getCapacity();
        return true;
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
                bogieIds.remove(bogieId);
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
     * Check whether a bogie with the given ID exists in the consist
     * @param bogieId ID to check
     * @return true if exists, false otherwise
     */
    public boolean containsBogie(String bogieId) {
        return findBogie(bogieId) != null;
    }

    /**
     * Add a passenger bogie to the train (convenience wrapper)
     * @param passengerBogie PassengerBogie to add
     * @return true if added successfully
     */
    public boolean addPassengerBogie(PassengerBogie passengerBogie) {
        return addBogie(passengerBogie);
    }

    /**
     * Remove a bogie by its position/index in the consist
     * @param index zero-based index of the bogie to remove
     * @return the removed Bogie if removed successfully, otherwise null
     */
    public Bogie removeBogieByIndex(int index) {
        if (index >= 0 && index < consist.size()) {
            Bogie removed = consist.remove(index);
            totalCapacity -= removed.getCapacity();
            bogieIds.remove(removed.getBogieId());
            return removed;
        }
        return null;
    }

    /**
     * Return a list of passenger bogies (copy) currently in the consist
     * @return List of PassengerBogie instances
     */
    public java.util.List<PassengerBogie> listPassengerBogies() {
        java.util.List<PassengerBogie> result = new java.util.ArrayList<>();
        for (Bogie bogie : consist) {
            if (bogie instanceof PassengerBogie) {
                result.add((PassengerBogie) bogie);
            }
        }
        return result;
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
