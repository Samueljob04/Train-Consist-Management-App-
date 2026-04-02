# Train Consist Management App - UC1

## Overview
This is the first use case (UC1) of the Train Consist Management App, a console-based Java application that simulates how a railway system manages a train's consist (collection of bogies attached to an engine).

## UC1: Initialize Train and Display Consist Summary

### Objective
Initialize the Train Consist Management App and display the initial state of the train with a mixed composition of passenger and goods bogies.

### What This Use Case Demonstrates

1. **Object-Oriented Programming Fundamentals**
   - Classes and Objects
   - Inheritance hierarchy (Bogie -> PassengerBogie/GoodsBogie -> Specific types)
   - Polymorphism (Abstract methods implementation)
   - Encapsulation (Data hiding and controlled access)

2. **Railway System Simulation**
   - Creating a train with specific engine type
   - Adding different bogie types to the train consist
   - Managing train composition and capacity

3. **Collections Management**
   - Using ArrayList to maintain the train consist
   - Iterating through bogies and displaying information

## Project Structure

```
src/
├── models/
│   ├── Bogie.java                 # Abstract base class for all bogies
│   ├── PassengerBogie.java        # Abstract class for passenger bogies
│   ├── GoodsBogie.java            # Abstract class for goods bogies
│   ├── Sleeper.java               # Concrete sleeper car implementation
│   ├── ACChair.java               # Concrete AC chair car implementation
│   ├── FirstClass.java            # Concrete first class car implementation
│   ├── RectangularGoods.java      # Concrete rectangular goods car implementation
│   ├── CylindricalGoods.java      # Concrete cylindrical goods car implementation
│   └── Train.java                 # Train class managing the consist
└── uc/
    └── UC1InitializeTrainDisplayConsist.java  # UC1 Implementation
```

## Classes Overview

### Model Classes

#### Bogie (Abstract)
Base class for all bogies with properties:
- `bogieId`: Unique identifier
- `capacity`: Maximum capacity
- `type`: Type of bogie

#### PassengerBogie (Abstract)
Extends Bogie with passenger-specific properties:
- `seatsOccupied`: Number of occupied seats
- `seatsAvailable`: Number of available seats
- `bookSeats()`: Method to book seats

#### GoodsBogie (Abstract)
Extends Bogie with cargo-specific properties:
- `cargoType`: Type of cargo
- `cargoWeight`: Current cargo weight
- `maxWeight`: Maximum weight capacity
- `hazardous`: Safety flag for hazardous materials
- `loadCargo()`: Load cargo method
- `unloadCargo()`: Unload cargo method

#### Concrete Bogie Classes
- **Sleeper**: Passenger bogie with berth-style accommodation (72 berths)
- **ACChair**: AC Chair passenger bogie with premium seating (96 seats)
- **FirstClass**: First class premium passenger bogie (48 seats)
- **RectangularGoods**: Goods bogie for rectangular cargo
- **CylindricalGoods**: Goods bogie for cylindrical cargo (tanks, barrels)

#### Train
Main class managing the consist:
- `trainId`: Unique train identifier
- `engineType`: Type of engine (Diesel, Electric, etc.)
- `consist`: List of bogies
- `addBogie()`: Add a bogie to the train
- `removeBogie()`: Remove a bogie from the train
- `findBogie()`: Search for a bogie by ID

## Running UC1

### Prerequisites
- Java 8 or higher
- Maven (optional, for compilation)

### Compilation

Using javac:
```bash
cd "Train Consist Management App"
javac -d bin src/models/*.java src/uc/*.java
```

Using Maven:
```bash
mvn clean compile
```

### Execution

Using java:
```bash
cd bin
java uc.UC1InitializeTrainDisplayConsist
```

Using Maven:
```bash
mvn exec:java -Dexec.mainClass="uc.UC1InitializeTrainDisplayConsist"
```

## Sample Output

```
===============================================
UC1: Initialize Train and Display Consist Summary
===============================================

Step 1: Initialize Train
------------------------
✓ Train created: TR-2026-001
✓ Engine Type: Diesel-Electric

Step 2: Adding Passenger Bogies
--------------------------------
✓ Added Sleeper Bogie: B-SLP-001 (72 berths)
✓ Added Sleeper Bogie: B-SLP-002 (72 berths)
✓ Added AC Chair Bogie: B-ACC-001 (96 seats)
✓ Added First Class Bogie: B-FC-001 (48 seats)

Step 3: Adding Goods Bogies
----------------------------
✓ Added Rectangular Goods Bogie: B-RG-001 (Non-hazardous Grain)
✓ Added Cylindrical Goods Bogie: B-CG-001 (Hazardous Petroleum)

Step 4: Train Consist Summary
=============================
Train ID: TR-2026-001
Engine Type: Diesel-Electric
Total Bogies: 6
Total Capacity: 552 units

Step 5: Detailed Bogie Information
===================================
1. Sleeper [B-SLP-001] | Berths - Occupied: 0, Available: 72
2. Sleeper [B-SLP-002] | Berths - Occupied: 0, Available: 72
3. AC Chair [B-ACC-001] | Seats - Occupied: 0, Available: 96
4. First Class [B-FC-001] | Seats - Occupied: 0, Available: 48
5. Rectangular Goods [B-RG-001] | Cargo: Grain, Weight: 0.00/50000.00 kg, Hazardous: false
6. Cylindrical Goods [B-CG-001] | Cargo: Petroleum, Weight: 0.00/40000.00 kg, Hazardous: true

Step 6: Consist Composition Breakdown
====================================
Passenger Bogies:
  - Sleeper: 2
  - AC Chair: 1
  - First Class: 1
Total Passenger Bogies: 4

Goods Bogies:
  - Rectangular Goods: 1
  - Cylindrical Goods: 1
Total Goods Bogies: 2

✓ Train initialization and consist display complete!
```

## Key Concepts Covered in UC1

1. **Abstraction**: Using abstract classes and methods to define contracts
2. **Inheritance**: Multi-level inheritance hierarchy
3. **Polymorphism**: Different bogie types implementing the same interface
4. **Encapsulation**: Private attributes with controlled access
5. **Collections**: Managing multiple objects in a list
6. **Type Checking**: Using instanceof to identify object types
7. **String Formatting**: Using printf-style formatting for output

## Future Use Cases

This UC1 forms the foundation for future use cases such as:
- UC2: Book Seats in Passenger Bogies
- UC3: Load/Unload Cargo in Goods Bogies
- UC4: Verify Safety Compliance
- UC5: Calculate Train Utilization
- UC6: Manage Train Operations

## Author
Samuel Paul

## License
MIT License
