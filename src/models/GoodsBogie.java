package models;

/**
 * Abstract class representing a goods/freight bogie with cargo tracking capabilities.
 * Extends Bogie class with cargo-specific attributes and safety constraints.
 */
public abstract class GoodsBogie extends Bogie {
    protected String cargoType;
    protected double cargoWeight;
    protected double maxWeight;
    protected boolean hazardous;

    /**
     * Constructor for creating a GoodsBogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Maximum cargo capacity (in units)
     * @param type Type of goods bogie (e.g., "Rectangular", "Cylindrical")
     * @param cargoType Type of cargo being transported
     * @param maxWeight Maximum weight this bogie can carry
     * @param hazardous Whether the cargo is hazardous
     */
    public GoodsBogie(String bogieId, int capacity, String type, 
                     String cargoType, double maxWeight, boolean hazardous) {
        super(bogieId, capacity, type);
        this.cargoType = cargoType;
        this.cargoWeight = 0.0;
        this.maxWeight = maxWeight;
        this.hazardous = hazardous;
    }

    /**
     * Get the cargo type
     * @return Type of cargo
     */
    public String getCargoType() {
        return cargoType;
    }

    /**
     * Get the current cargo weight
     * @return Current weight of cargo
     */
    public double getCargoWeight() {
        return cargoWeight;
    }

    /**
     * Get the maximum weight capacity
     * @return Maximum weight this bogie can carry
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Check if cargo is hazardous
     * @return true if hazardous, false otherwise
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * Load cargo into the bogie
     * @param weight Weight of cargo to load
     * @return true if loading is successful, false if it exceeds capacity
     */
    public boolean loadCargo(double weight) {
        if (cargoWeight + weight <= maxWeight) {
            cargoWeight += weight;
            return true;
        }
        return false;
    }

    /**
     * Unload cargo from the bogie
     * @param weight Weight of cargo to unload
     * @return true if unloading is successful, false if weight exceeds current cargo
     */
    public boolean unloadCargo(double weight) {
        if (cargoWeight >= weight && weight > 0) {
            cargoWeight -= weight;
            return true;
        }
        return false;
    }

    /**
     * Get string representation of goods bogie details
     * @return String with cargo information
     */
    @Override
    public String getDetails() {
        return String.format("%s | Cargo: %s, Weight: %.2f/%.2f kg, Hazardous: %b", 
            toString(), cargoType, cargoWeight, maxWeight, hazardous);
    }
}
