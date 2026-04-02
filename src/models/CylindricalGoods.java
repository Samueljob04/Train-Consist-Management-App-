package models;

/**
 * Concrete class representing a Cylindrical Goods bogie.
 * Cylindrical goods bogies are designed for cylindrical cargo such as tanks or barrels.
 */
public class CylindricalGoods extends GoodsBogie {

    /**
     * Constructor for creating a Cylindrical Goods bogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Storage capacity (in units)
     * @param cargoType Type of cargo
     * @param maxWeight Maximum weight capacity
     * @param hazardous Whether cargo is hazardous
     */
    public CylindricalGoods(String bogieId, int capacity, String cargoType, 
                           double maxWeight, boolean hazardous) {
        super(bogieId, capacity, "Cylindrical", cargoType, maxWeight, hazardous);
    }

    /**
     * Get details specific to Cylindrical Goods bogie
     * @return Detailed information about cylindrical goods configuration
     */
    @Override
    public String getDetails() {
        return String.format("Cylindrical Goods [%s] | Cargo: %s, Weight: %.2f/%.2f kg, Hazardous: %b", 
            bogieId, cargoType, cargoWeight, maxWeight, hazardous);
    }
}
