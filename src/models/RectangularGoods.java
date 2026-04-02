package models;

/**
 * Concrete class representing a Rectangular Goods bogie.
 * Rectangular goods bogies are designed for standard box-shaped cargo.
 */
public class RectangularGoods extends GoodsBogie {

    /**
     * Constructor for creating a Rectangular Goods bogie
     * @param bogieId Unique identifier for the bogie
     * @param capacity Storage capacity (in units)
     * @param cargoType Type of cargo
     * @param maxWeight Maximum weight capacity
     * @param hazardous Whether cargo is hazardous
     */
    public RectangularGoods(String bogieId, int capacity, String cargoType, 
                           double maxWeight, boolean hazardous) {
        super(bogieId, capacity, "Rectangular", cargoType, maxWeight, hazardous);
    }

    /**
     * Get details specific to Rectangular Goods bogie
     * @return Detailed information about rectangular goods configuration
     */
    @Override
    public String getDetails() {
        return String.format("Rectangular Goods [%s] | Cargo: %s, Weight: %.2f/%.2f kg, Hazardous: %b", 
            bogieId, cargoType, cargoWeight, maxWeight, hazardous);
    }
}
