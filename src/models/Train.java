package models;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Class representing a Train with its consist (collection of bogies).
 * Manages the composition and properties of the train.
 */
public class Train {
    private String trainId;
    private String engineType;
    private List<Bogie> consist;
    private int totalCapacity;
    private Set<String> bogieIds; // track unique bogie IDs to prevent duplicates (preserves insertion order)
    private Map<String, Integer> bogieCapacityMap; // UC6: map bogie ID -> capacity

    /**
     * Constructor for creating a Train
     * @param trainId Unique identifier for the train
     * @param engineType Type of engine (e.g., "Diesel", "Electric")
     */
    public Train(String trainId, String engineType) {
        this.trainId = trainId;
        this.engineType = engineType;
        // Use LinkedList to better model chaining and efficient insert/remove operations
        this.consist = new LinkedList<>();
        this.totalCapacity = 0;
        // Use LinkedHashSet to enforce uniqueness while preserving insertion order (UC4)
        this.bogieIds = new LinkedHashSet<>();
        // UC6: store capacities keyed by bogie ID
        this.bogieCapacityMap = new HashMap<>();
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
     * Ensures bogie IDs remain unique across the train (UC3/UC4/UC6)
     * Also records capacity mapping for the bogie
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
        bogieCapacityMap.put(id, bogie.getCapacity()); // UC6
        totalCapacity += bogie.getCapacity();
        return true;
    }

    /**
     * Push a bogie onto the consist (LIFO semantics for last-attachment scenarios)
     * Alias for addBogie to emphasize stack-like attachment
     * @param bogie Bogie to push/attach
     * @return true if attached successfully
     */
    public boolean pushBogie(Bogie bogie) {
        return addBogie(bogie);
    }

    /**
     * Pop the last attached bogie (LIFO behavior) - used for rollback / emergency detach
     * @return the removed Bogie if present, otherwise null
     */
    public Bogie popLastBogie() {
        if (consist.isEmpty()) {
            return null;
        }
        int lastIndex = consist.size() - 1;
        Bogie removed = consist.remove(lastIndex);
        totalCapacity -= removed.getCapacity();
        bogieIds.remove(removed.getBogieId());
        bogieCapacityMap.remove(removed.getBogieId()); // UC6
        return removed;
    }

    /**
     * Peek at the last attached bogie without removing it
     * @return last Bogie or null if consist is empty
     */
    public Bogie peekLastBogie() {
        if (consist.isEmpty()) {
            return null;
        }
        return consist.get(consist.size() - 1);
    }

    /**
     * Whether the consist is empty
     * @return true if no bogies attached
     */
    public boolean isConsistEmpty() {
        return consist.isEmpty();
    }

    /**
     * Get the number of bogies (stack size)
     * @return number of bogies
     */
    public int size() {
        return consist.size();
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
                bogieCapacityMap.remove(bogieId); // UC6
                return true;
            }
        }
        return false;
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
            bogieCapacityMap.remove(removed.getBogieId()); // UC6
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
     * Return an ordered list of bogie IDs in insertion order
     * @return List of bogie IDs preserving insertion order
     */
    public List<String> getOrderedBogieIds() {
        return new ArrayList<>(bogieIds);
    }

    /**
     * UC6: Get the capacity associated with a bogie ID
     * @param bogieId ID of the bogie
     * @return capacity if present, or null if bogie ID not known
     */
    public Integer getBogieCapacity(String bogieId) {
        return bogieCapacityMap.get(bogieId);
    }

    /**
     * UC6: Return a copy of the bogie capacity mapping (ID -> capacity)
     * @return Map copy of bogie capacities
     */
    public Map<String, Integer> getBogieCapacityMap() {
        return new HashMap<>(bogieCapacityMap);
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
     * Return passenger bogies sorted by seating capacity (descending)
     * Uses a Comparator to order passenger bogies by their capacity.
     * @return sorted list of PassengerBogie (descending capacity)
     */
    public java.util.List<PassengerBogie> getPassengerBogiesSortedByCapacityDesc() {
        java.util.List<PassengerBogie> list = listPassengerBogies();
        list.sort(new java.util.Comparator<PassengerBogie>() {
            @Override
            public int compare(PassengerBogie a, PassengerBogie b) {
                return Integer.compare(b.getCapacity(), a.getCapacity()); // descending
            }
        });
        return list;
    }

    /**
     * UC8: Filter passenger bogies with capacity >= minCapacity using Stream API
     * @param minCapacity minimum seating capacity threshold
     * @return filtered list of PassengerBogie meeting the threshold
     */
    public java.util.List<PassengerBogie> filterPassengerBogiesByMinCapacity(int minCapacity) {
        return listPassengerBogies().stream()
                .filter(pb -> pb.getCapacity() >= minCapacity)
                .toList();
    }

    /**
     * UC8: Generic stream-based filter allowing any predicate on PassengerBogie
     * @param predicate java.util.function.Predicate to filter passenger bogies
     * @return filtered list based on predicate
     */
    public java.util.List<PassengerBogie> filterPassengerBogies(java.util.function.Predicate<PassengerBogie> predicate) {
        return listPassengerBogies().stream()
                .filter(predicate)
                .toList();
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
