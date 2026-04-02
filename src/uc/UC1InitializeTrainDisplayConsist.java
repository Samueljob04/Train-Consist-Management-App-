package uc;

import models.*;

/**
 * UC1: Initialize Train and Display Consist Summary
 * 
 * This use case demonstrates:
 * 1. Creating a Train object with specific engine type
 * 2. Adding different types of bogies (Passenger and Goods) to the train consist
 * 3. Displaying a comprehensive summary of the train composition
 * 4. Showcasing the object-oriented design with inheritance and polymorphism
 * 
 * Key Concepts Covered:
 * - Classes and Objects: Creating instances of Train and various Bogie types
 * - Inheritance: Bogie -> PassengerBogie/GoodsBogie -> Specific bogie types
 * - Polymorphism: Using abstract methods getDetails() across different bogie types
 * - Collections: Using ArrayList to manage train consist
 * - Encapsulation: Private attributes with public getter methods
 */
public class UC1InitializeTrainDisplayConsist {

    /**
     * Main method to demonstrate UC1
     * Initializes a train with mixed bogies and displays summary
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("UC1: Initialize Train and Display Consist Summary");
        System.out.println("===============================================\n");

        // Step 1: Initialize the Train with Engine
        System.out.println("Step 1: Initialize Train");
        System.out.println("------------------------");
        Train passengerTrain = new Train("TR-2026-001", "Diesel-Electric");
        System.out.println("✓ Train created: " + passengerTrain.getTrainId());
        System.out.println("✓ Engine Type: " + passengerTrain.getEngineType());
        System.out.println();

        // Step 2: Create and Add Passenger Bogies
        System.out.println("Step 2: Adding Passenger Bogies");
        System.out.println("--------------------------------");
        
        Sleeper sleeper1 = new Sleeper("B-SLP-001", 72);
        passengerTrain.addBogie(sleeper1);
        System.out.println("✓ Added Sleeper Bogie: B-SLP-001 (72 berths)");

        Sleeper sleeper2 = new Sleeper("B-SLP-002", 72);
        passengerTrain.addBogie(sleeper2);
        System.out.println("✓ Added Sleeper Bogie: B-SLP-002 (72 berths)");

        ACChair acChair1 = new ACChair("B-ACC-001", 96);
        passengerTrain.addBogie(acChair1);
        System.out.println("✓ Added AC Chair Bogie: B-ACC-001 (96 seats)");

        FirstClass firstClass1 = new FirstClass("B-FC-001", 48);
        passengerTrain.addBogie(firstClass1);
        System.out.println("✓ Added First Class Bogie: B-FC-001 (48 seats)");
        System.out.println();

        // Step 3: Create and Add Goods Bogies
        System.out.println("Step 3: Adding Goods Bogies");
        System.out.println("----------------------------");
        
        RectangularGoods rectGoods1 = new RectangularGoods("B-RG-001", 500, "Grain", 50000.0, false);
        passengerTrain.addBogie(rectGoods1);
        System.out.println("✓ Added Rectangular Goods Bogie: B-RG-001 (Non-hazardous Grain)");

        CylindricalGoods cylGoods1 = new CylindricalGoods("B-CG-001", 400, "Petroleum", 40000.0, true);
        passengerTrain.addBogie(cylGoods1);
        System.out.println("✓ Added Cylindrical Goods Bogie: B-CG-001 (Hazardous Petroleum)");
        System.out.println();

        // Step 4: Display Train Consist Summary
        System.out.println("Step 4: Train Consist Summary");
        System.out.println("=============================");
        displayConsistSummary(passengerTrain);
        System.out.println();

        // Step 5: Display Detailed Information for Each Bogie
        System.out.println("Step 5: Detailed Bogie Information");
        System.out.println("===================================");
        displayDetailedBogieInfo(passengerTrain);
        System.out.println();

        // Step 6: Display Consist Composition Breakdown
        System.out.println("Step 6: Consist Composition Breakdown");
        System.out.println("====================================");
        displayCompositionBreakdown(passengerTrain);
    }

    /**
     * Display summary information about the train and its consist
     * @param train Train object to display summary for
     */
    private static void displayConsistSummary(Train train) {
        System.out.println("Train ID: " + train.getTrainId());
        System.out.println("Engine Type: " + train.getEngineType());
        System.out.println("Total Bogies: " + train.getConsistSize());
        System.out.println("Total Capacity: " + train.getTotalCapacity() + " units");
        System.out.println();
    }

    /**
     * Display detailed information for each bogie in the consist
     * @param train Train object containing bogies
     */
    private static void displayDetailedBogieInfo(Train train) {
        int bogieNumber = 1;
        for (Bogie bogie : train.getConsist()) {
            System.out.println(bogieNumber + ". " + bogie.getDetails());
            bogieNumber++;
        }
    }

    /**
     * Display breakdown of consist composition by bogie type
     * @param train Train object to analyze
     */
    private static void displayCompositionBreakdown(Train train) {
        int sleeperCount = 0;
        int acChairCount = 0;
        int firstClassCount = 0;
        int rectangularGoodsCount = 0;
        int cylindricalGoodsCount = 0;

        for (Bogie bogie : train.getConsist()) {
            if (bogie instanceof Sleeper) {
                sleeperCount++;
            } else if (bogie instanceof ACChair) {
                acChairCount++;
            } else if (bogie instanceof FirstClass) {
                firstClassCount++;
            } else if (bogie instanceof RectangularGoods) {
                rectangularGoodsCount++;
            } else if (bogie instanceof CylindricalGoods) {
                cylindricalGoodsCount++;
            }
        }

        System.out.println("Passenger Bogies:");
        System.out.println("  - Sleeper: " + sleeperCount);
        System.out.println("  - AC Chair: " + acChairCount);
        System.out.println("  - First Class: " + firstClassCount);
        System.out.println("Total Passenger Bogies: " + (sleeperCount + acChairCount + firstClassCount));
        System.out.println();

        System.out.println("Goods Bogies:");
        System.out.println("  - Rectangular Goods: " + rectangularGoodsCount);
        System.out.println("  - Cylindrical Goods: " + cylindricalGoodsCount);
        System.out.println("Total Goods Bogies: " + (rectangularGoodsCount + cylindricalGoodsCount));
        System.out.println();

        System.out.println("✓ Train initialization and consist display complete!");
    }
}
